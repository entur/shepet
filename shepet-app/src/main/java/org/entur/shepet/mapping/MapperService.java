package org.entur.shepet.mapping;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

import org.entur.shepet.mapping.util.*;
import org.entur.shepet.model.Kjoretoydata;
import org.entur.shepet.model.Kode;
import org.entur.shepet.model.TekniskeData;
import org.entur.shepet.model.dto.FetchVehicleErrorDto;
import org.entur.shepet.model.dto.VehicleBulkInputDto;
import org.entur.netex2.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBElement;

@Service
public class MapperService {
    private static final Logger logger = LoggerFactory.getLogger(MapperService.class);
    private final SobekResourceFrameExporter sobekResourceFrameExporter;
    private final PublicationDeliveryCreator publicationDeliveryCreator;
    private final ExportTimeZone exportTimeZone;
    private static final ObjectFactory netexObjectFactory = new ObjectFactory();

    public MapperService(PublicationDeliveryCreator publicationDeliveryCreator,
                         SobekResourceFrameExporter sobekResourceFrameExporter,
                         ExportTimeZone exportTimeZone) {
        this.publicationDeliveryCreator = publicationDeliveryCreator;
        this.sobekResourceFrameExporter = sobekResourceFrameExporter;
        this.exportTimeZone = exportTimeZone;
    }

    public PublicationDeliveryStructure exportPublicationDeliveryWithAutosysVehicle(List<Kjoretoydata> kjoretoyList, List<FetchVehicleErrorDto> fetchErrors, String dataOwner) {
        return exportPublicationDeliveryWithAutosysVehicle(kjoretoyList, fetchErrors, dataOwner, List.of());
    }

    public PublicationDeliveryStructure exportPublicationDeliveryWithAutosysVehicle(
            List<Kjoretoydata> kjoretoyList, List<FetchVehicleErrorDto> fetchErrors, String dataOwner, List<VehicleBulkInputDto> vehicleInputs) {
        logger.info("Preparing publication delivery export");

        final ResourceFrame netexResourceFrame = sobekResourceFrameExporter.createResourceFrame(dataOwner);


        logger.info("Preparing scrollable iterators");
        prepareVehicleTypes(kjoretoyList, netexResourceFrame, dataOwner);
        prepareVehicleModels(kjoretoyList,  netexResourceFrame, dataOwner);
        prepareVehicles(kjoretoyList, netexResourceFrame, vehicleInputs, dataOwner);
        prepareFetchErrors(fetchErrors, netexResourceFrame);

        return publicationDeliveryCreator.createPublicationDelivery(netexResourceFrame);
    }

    private void prepareFetchErrors(List<FetchVehicleErrorDto> fetchErrors, ResourceFrame netexResourceFrame) {
        if (fetchErrors == null || fetchErrors.isEmpty()) {
            logger.info("No fetch errors to serialize.");
            return;
        }

        logger.info("Preparing fetch error key-values from {} fetch errors", fetchErrors.size());

        int index = 0;
        for (FetchVehicleErrorDto fetchError : fetchErrors) {
            // SetToKeyValues creates the KeyList if needed and skips null values (not allowed by the XSD)
            KeyValuesHelper.SetToKeyValues(netexResourceFrame,
                    "fetchError-registrationNumber-" + index, fetchError.getRegistrationNumber());
            KeyValuesHelper.SetToKeyValues(netexResourceFrame,
                    "fetchError-message-" + index, fetchError.getMessage());

            index++;
        }

        logger.info("Fetch error key-values successfully serialized to netexResourceFrame.");
    }
    
    private void prepareVehicleModels(List<Kjoretoydata> kjoretoyList, org.entur.netex2.model.ResourceFrame resourceFrame, String dataOwner) {

        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicle models to export");

            VehicleModelsInFrame_RelStructure vehicleModelsInFrameRelStructure = new VehicleModelsInFrame_RelStructure();
            
            // Deduplicate vehicle models by their ID (stable, order-preserving)
            Map<String, VehicleModel> modelsById = new LinkedHashMap<>();
            for (Kjoretoydata vt : kjoretoyList) {
                modelsById.computeIfAbsent(vehicleModelId(vt, dataOwner), id ->
                        new org.entur.netex2.model.VehicleModel()
                                .withId(id)
                                .withVersion("1")
                                .withDescription(createMultilingualString(modelDescription(vt))));
            }
            List<org.entur.netex2.model.VehicleModel> vehicleModels = List.copyOf(modelsById.values());

            logger.info("Reduced to {} unique vehicle models", vehicleModels.size());

            vehicleModelsInFrameRelStructure.withVehicleModel(vehicleModels);
            resourceFrame.setVehicleModels(vehicleModelsInFrameRelStructure);
        } else {
            logger.info("No vehicle models to export");
        }
    }

    private MultilingualString createMultilingualString(String value) {
        return new MultilingualString().withContent(List.of(createTextType(value)));
    }

    private JAXBElement<? extends TextType> createTextType(String value){
        return netexObjectFactory.createMultilingualStringText(new TextType()
                .withValue(value));
    }

    private String vehicleModelId(Kjoretoydata vt, String dataOwner) {
        var godkjenning = vt.getGodkjenning();
        var tekniskGodkjenning = godkjenning != null ? godkjenning.getTekniskGodkjenning() : null;
        var klassifisering = tekniskGodkjenning != null ? tekniskGodkjenning.getKjoretoyklassifisering() : null;
        var efTypegodkjenning = klassifisering != null ? klassifisering.getEfTypegodkjenning() : null;

        if (efTypegodkjenning != null && efTypegodkjenning.getTypegodkjenningNrTekst() != null) {
            return "AUTOSYS:VehicleModel:" + dataOwner.replace(':', '-') + "_" + efTypegodkjenning.getTypegodkjenningNrTekst();
        }
        // Stable fallback: depends only on the vehicle itself, not on its position in the batch
        return "AUTOSYS:VehicleModel:" + dataOwner.replace(':', '-') + "_" + fallbackKey(vt);
    }

    private String vehicleTypeId(Kjoretoydata vt, String dataOwner) {
        var godkjenning = vt.getGodkjenning();
        var tekniskGodkjenning = godkjenning != null ? godkjenning.getTekniskGodkjenning() : null;
        var klassifisering = tekniskGodkjenning != null ? tekniskGodkjenning.getKjoretoyklassifisering() : null;
        var efTypegodkjenning = klassifisering != null ? klassifisering.getEfTypegodkjenning() : null;

        if (efTypegodkjenning != null && efTypegodkjenning.getTypegodkjenningNrTekst() != null) {
            return "AUTOSYS:VehicleType:" + dataOwner.replace(':', '-') + "_" + efTypegodkjenning.getTypegodkjenningNrTekst();
        }
        // Stable fallback: depends only on the vehicle itself, not on its position in the batch
        return "AUTOSYS:VehicleType:" + dataOwner.replace(':', '-') + "_" + fallbackKey(vt);
    }

    private String passengerCapacityId(Kjoretoydata vt, String dataOwner) {
        var godkjenning = vt.getGodkjenning();
        var tekniskGodkjenning = godkjenning != null ? godkjenning.getTekniskGodkjenning() : null;
        var klassifisering = tekniskGodkjenning != null ? tekniskGodkjenning.getKjoretoyklassifisering() : null;
        var efTypegodkjenning = klassifisering != null ? klassifisering.getEfTypegodkjenning() : null;

        if (efTypegodkjenning != null && efTypegodkjenning.getTypegodkjenningNrTekst() != null) {
            return "AUTOSYS:PassengerCapacity:" + dataOwner.replace(':', '-') + "_" + efTypegodkjenning.getTypegodkjenningNrTekst();
        }
        // Stable fallback: depends only on the vehicle itself, not on its position in the batch
        return "AUTOSYS:PassengerCapacity:" + dataOwner.replace(':', '-') + "_" + fallbackKey(vt);
    }
    
    private String modelDescription(Kjoretoydata vt) {
        if (vt.getGodkjenning() == null) return "";
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return "";
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getTekniskeData() == null) return "";
        var tekniskeData = tekniskGodkjenning.getTekniskeData();
        if (tekniskeData.getGenerelt() == null) return "";
        var generelt = tekniskeData.getGenerelt();
        if (generelt.getMerke() == null || generelt.getMerke().isEmpty()) return "";
        var merke = generelt.getMerke().getFirst();
        if (generelt.getHandelsbetegnelse() == null) return merke.getMerke();
        return merke.getMerke() + generelt.getHandelsbetegnelse();
    }

    private void prepareVehicles(List<Kjoretoydata> kjoretoyList, org.entur.netex2.model.ResourceFrame resourceFrame,
                                 List<VehicleBulkInputDto> vehicleInputs, String dataOwner) {
        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicles to export");

            VehiclesInFrame_RelStructure vehiclesInFrame_relStructure = new VehiclesInFrame_RelStructure();

            List<org.entur.netex2.model.Vehicle> vehicles = kjoretoyList.stream()
                    .map(kjoretoy -> mapOneVehicle(kjoretoy, vehicleInputs, dataOwner))
                    .toList();

            vehiclesInFrame_relStructure.withVehicle(vehicles);
            resourceFrame.setVehicles(vehiclesInFrame_relStructure);
        } else {
            logger.info("No vehicles to export");
        }
    }

    private org.entur.netex2.model.Vehicle mapOneVehicle(Kjoretoydata kjoretoy,
                                                         List<VehicleBulkInputDto> vehicleInputs,
                                                         String dataOwner) {
        org.entur.netex2.model.Vehicle vehicle = new org.entur.netex2.model.Vehicle()
                .withChassisNumber(kjoretoy.getKjoretoyId().getUnderstellsnummer())
                .withRegistrationNumber(kjoretoy.getKjoretoyId().getKjennemerke())
                .withId("AUTOSYS:Vehicle:" + dataOwner.replace(':', '-') + "_" + kjoretoy.getKjoretoyId().getKjennemerke())
                .withVersion("1")
                .withTransportTypeRef(createVechicleTypeRef(kjoretoy, dataOwner))
                .withVehicleModelRef(createModelRef(kjoretoy, dataOwner));

        if (kjoretoy.getRegistrering() != null && kjoretoy.getRegistrering().getFomTidspunkt() != null) {
            vehicle.withRegistrationDate(kjoretoy.getRegistrering().getFomTidspunkt()
                    .atZoneSameInstant(exportTimeZone.getDefaultTimeZoneId()).toLocalDate());
        }

        // Find matching input DTO and set operational number (pick first match if multiple)
        String registrationNumber = normalizeRegistrationNumber(kjoretoy.getKjoretoyId().getKjennemerke());
        vehicleInputs.stream()
                .filter(input -> registrationNumber.equals(input.getRegistrationNumber()))
                .findFirst()
                .ifPresent(input -> {
                    if (input.getOperationalNumber() != null && !input.getOperationalNumber().isEmpty()) {
                        vehicle.withOperationalNumber(input.getOperationalNumber());
                    }
                });

        return vehicle;
    }

    private VehicleModelRefStructure createModelRef(Kjoretoydata vt, String dataOwner) {
        VehicleModelRefStructure vehicleModelRefStructure = new VehicleModelRefStructure();
        vehicleModelRefStructure.setRef(vehicleModelId(vt, dataOwner));
        return vehicleModelRefStructure;
    }

    private JAXBElement<? extends TransportTypeRefStructure> createVechicleTypeRef(Kjoretoydata vt, String dataOwner) {
        TransportTypeRefStructure transportTypeRefStructure = new TransportTypeRefStructure();
        transportTypeRefStructure.setRef(vehicleTypeId(vt, dataOwner));
        return netexObjectFactory.createTransportTypeRef(transportTypeRefStructure);
    }

    private void prepareVehicleTypes(List<Kjoretoydata> kjoretoyList, org.entur.netex2.model.ResourceFrame resourceFrame, String dataOwner) {
        // Override lists with custom iterator to be able to scroll database results on the fly.
        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicle types to export");

            VehicleTypesInFrame_RelStructure vehicleTypesInFrameRelStructure = new VehicleTypesInFrame_RelStructure();
            
            // Deduplicate vehicle types by their ID
            List<org.entur.netex2.model.VehicleType> vehicleTypes = kjoretoyList.stream()
                    .collect(Collectors.toMap(
                            vt -> vehicleTypeId(vt, dataOwner),
                            vt -> mapOneVehicleType(vt, dataOwner),
                            (existing, replacement) -> existing // Keep first occurrence
                    ))
                    .values()
                    .stream()
                    .toList();

            logger.info("Reduced to {} unique vehicle types", vehicleTypes.size());

            Collection<JAXBElement<? extends DataManagedObjectStructure>> jaxbVehicleTypes = vehicleTypes.stream().map(vt -> new ObjectFactory().createVehicleType(vt)).collect(Collectors.toSet());
            vehicleTypesInFrameRelStructure.withTransportType(jaxbVehicleTypes);
            resourceFrame.setVehicleTypes(vehicleTypesInFrameRelStructure);
        } else {
            logger.info("No vehicle types to export");
        }
    }

    private VehicleType mapOneVehicleType(Kjoretoydata vt, String dataOwner) {
        var vehicleType = new org.entur.netex2.model.VehicleType()
                .withId(vehicleTypeId(vt, dataOwner))
                .withVersion("1");

        if (vt.getGodkjenning() == null) return vehicleType;
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return vehicleType;
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if(tekniskGodkjenning.getKjoretoyklassifisering() == null) return vehicleType;
        var kjoretoyKlassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if(kjoretoyKlassifisering.getTekniskKode() == null) return vehicleType;
        var tekniskKode = kjoretoyKlassifisering.getTekniskKode();
        vehicleType.setTransportMode(mapTransportMode(tekniskKode));

        if (tekniskGodkjenning.getTekniskeData() == null) return vehicleType;
        var tekniskeData = tekniskGodkjenning.getTekniskeData();

        if(tekniskeData.getPersontall() != null) {
            var passengerCapacityStructure = mapPassengerCapacity(vt, tekniskeData.getPersontall(), dataOwner);
            if (passengerCapacityStructure != null) vehicleType.withPassengerCapacity(passengerCapacityStructure);
        }

        var vekter = tekniskeData.getVekter();
        if(vekter != null && vekter.getEgenvekt() != null) {
            vehicleType.withWeight(BigDecimal.valueOf(vekter.getEgenvekt()));
        }

        var dimensjoner = tekniskeData.getDimensjoner();
        if(dimensjoner != null) {
            if(dimensjoner.getBredde() != null) vehicleType.withWidth(BigDecimal.valueOf(dimensjoner.getBredde()));
            if(dimensjoner.getLengde() != null) vehicleType.withLength(BigDecimal.valueOf(dimensjoner.getLengde()));
            if(dimensjoner.getHoyde() != null) vehicleType.withHeight(BigDecimal.valueOf(dimensjoner.getHoyde()));
        }

        var miljoData = tekniskeData.getMiljodata();
        if(miljoData != null) {
            if(miljoData.getEuroKlasse() != null) vehicleType.withEuroClass(mapEuroClass(miljoData.getEuroKlasse()));
            if(miljoData.getMiljoOgdrivstoffGruppe() != null) {
                vehicleType.withFuelTypes(miljoData.getMiljoOgdrivstoffGruppe().stream().map(this::mapFuelType).toList());
            }
        }

        var motorOgDrivverk = tekniskeData.getMotorOgDrivverk();
        if(motorOgDrivverk != null) {
            if (motorOgDrivverk.getMaksimumHastighet() != null && !motorOgDrivverk.getMaksimumHastighet().isEmpty()) {
                vehicleType.withMaximumVelocity(BigDecimal.valueOf(motorOgDrivverk.getMaksimumHastighet().getFirst()));
            }
            if (motorOgDrivverk.getMotor() != null && !motorOgDrivverk.getMotor().isEmpty()) {
                vehicleType.withPropulsionTypes(motorOgDrivverk.getMotor().stream().map(this::mapPropulsionType).toList());

                // Calculate sum of getMaksNettoEffekt from all drivstoff of all motor elements
                Double totalMaksNettoEffekt = motorOgDrivverk.getMotor().stream()
                    .filter(motor -> motor.getDrivstoff() != null)
                    .flatMap(motor -> motor.getDrivstoff().stream())
                    .map(TekniskeData.Drivstoff::getMaksNettoEffekt)
                    .filter(Objects::nonNull)
                        .reduce(0.0, Double::sum);
                
                if (totalMaksNettoEffekt > 0) {
                    KeyValuesHelper.SetToKeyValues(vehicleType, "MaximumEngineEffectKW", totalMaksNettoEffekt.toString());
                }
            }
            if(motorOgDrivverk.getHybridKategori() != null) {
                if(motorOgDrivverk.getHybridKategori().getKodeVerdi().equals("LADBAR")) {
                    KeyValuesHelper.SetToKeyValues(vehicleType, "HybridCategory", "chargeable");
                } else if(motorOgDrivverk.getHybridKategori().getKodeVerdi().equals("IKKE_LADBAR")) {
                    KeyValuesHelper.SetToKeyValues(vehicleType, "HybridCategory", "nonChargeable");
                }
            }
        }

        if (tekniskeData.getKarosseriOgLasteplan() != null && tekniskeData.getKarosseriOgLasteplan().getKarosseritype() != null) {
            vehicleType.withLowFloor(isLowFloor(tekniskeData.getKarosseriOgLasteplan().getKarosseritype()));
        }

        return vehicleType;
    }

    private String mapEuroClass(Kode euroKode) {
        if(euroKode.getKodeVerdi() == null) return null;

        return switch (euroKode.getKodeVerdi()) {
            case "0" -> null; // Nullutslipp	0-utslipp
//            1L	Euro 1	Euro 1L - 70/220/EØF*93/59/EØF - omfatter også tunge bensin M og N
//            1T	Euro I	Euro 1T - 88/77/EØF*91/542/EØF
            case "1L", "1T" -> "Euro1";
//        2L	Euro 2	Euro 2L - 70/220/EØF*96/44/EF eller 70/220/EØF*96/69/EF - omfatter også tunge bensin M og N
//        2T	Euro II	Euro 2T - 88/77/EØF*96/1/EF
            case "2L", "2T" -> "Euro2";
//        3L	Euro 3	Euro 3L - 70/220/EØF*2003/76/EF - omfatter også tunge bensin M og N
//        3T	Euro III	Euro 3T - 88/77/EØF*2001/27/EF
            case "3L", "3T" -> "Euro3";
//        4L	Euro 4	Euro 4L - 70/220/EØF*2003/76/EF - omfatter også tunge bensin M og N
//        4M	Euro 4M	Euro 4M - Avgassdirektiv EU 134/2014 (MC)
//                4T	Euro IV	Euro 4T - 88/77/EØF*2001/27/EF eller 2005/55/EF*2006/51/EF
            case "4L", "4M", "4T" -> "Euro4";
//        5L	Euro 5	Euro 5L - EF 715/2007*EF 459/2012 (med bokstavene A til M)
//        5M	Euro 5M	Euro 5M - Avgassdirektiv EU 134/2014 (MC)
//                5T	Euro V	Euro 5T - 88/77/EØF*2001/27/EF eller 2005/55/EF*2008/74/EF
            case "5L", "5M", "5T" -> "Euro5";
//        6L	Euro 6	Euro 6L - EF 715/2007*EF 459/2012 (med bokstavene N til ZC)
//        6M	Euro 6M	Euro 6M - Avgassdirektiv EU 134/2014 (MC)
//                6T	Euro VI	Euro 6T - EF 595/2009
            case "6L", "6M", "6T" -> "Euro6";
//        ET	EEV	EEV (Enhanced Environmentally Friendly Vehicle), frivillig Euro-avgasskode for tunge kjøretøy
//        U	Før Euro	Ikke Euro-klassifisert (før 1995, se kravnivå iht. KTK)
            case "ET" -> null;
            case "U" -> null;
            default -> null;
        };
    }

    private AllPublicTransportModesEnumeration mapTransportMode(Kode tekniskKode) {
        return switch (tekniskKode.getKodeVerdi()) { // Beltebil (BB)
            // Beltemotorsykkel (BM)
            // Beltetraktor (C1) tung, bred	Beltetraktor med maksimal hastighet 40 km/t eller mindre, minste sporvidde for akselen nærmest føreren 1150 mm eller over, egenvekt over 600 kg, frihøyde 1000 mm eller mindre. Omfatter Jordbruks- eller skogbrukstraktor og traktor godkjent 1. juli 2005 og senere.
            // Beltetraktor (C2) tung, smal	Beltetraktor med maksimal hastighet 40 km/t eller mindre, minste sporvidde under 1150 mm, egenvekt over 600 kg, frihøyde ikke over 600 mm. Når tyngdepunktshøyde delt på sporvidde er over 0,9, er maksimal hastighet 30 km/t. Omfatter Jordbruks- eller skogbrukstraktor og traktor godkjent 1. juli 2005 og senere.
            // Beltetraktor (C3) lett	Beltetraktor med maksimal hastighet 40 km/t eller mindre og egenvekt 600 kg eller mindre. Omfatter Jordbruks- eller skogbrukstraktor og traktor godkjent 1. juli 2005 og senere.
            // Beltetraktor (C4) særlige formål	Beltetraktor til særlige formål og med maksimal hastighet 40 km/t eller mindre. Omfatter Jordbruks- eller skogbrukstraktor og traktor godkjent 1. juli 2005 og senere.
            // Beltetraktor (C5) hastighet > 40 km/t	Beltetraktor med maksimal hastighet over 40 km/t. Omfatter Jordbruks- eller skogbrukstraktor og traktor godkjent 1. juli 2005 og senere.
            case "BB", "BM", "C1", "C2", "C3", "C4",
                 "C5" ->
                    AllPublicTransportModesEnumeration.SNOW_AND_ICE;
            // Buss - totalvekt inntil 5000 kg	Bil for persontransport med over 8 sitteplasser i tillegg til førersetet og tillatt totalvekt ikke over 5000 kg
            // Buss (terreng) - totalvekt inntil 5000 kg	Terrenggående bil for persontransport med over 8 sitteplasser i tillegg til førersetet og tillatt totalvekt ikke over 5000 kg
            // Buss - totalvekt > 5000 kg	Bil for persontransport med over 8 sitteplasser i tillegg til førersetet og tillatt totalvekt over 5 000 kg (Buss)
            // Buss (terreng) - totalvekt > 5000 kg	Terrenggående bil for persontransport med over 8 sitteplasser i tillegg til førersetet og tillatt totalvekt over 5 000 kg (Buss)
            case "M2", "M2G", "M3",
                 "M3G" ->
                    AllPublicTransportModesEnumeration.BUS;
            // Personbil	Bil for persontransport med høyst 8 sitteplasser i tillegg til førersetet (Personbil)
            // Personbil (terreng)	Terrenggående bil for persontransport med høyst 8 sitteplasser i tillegg til førersetet
            case "M1",
                 "M1G" ->
                    AllPublicTransportModesEnumeration.TAXI;  // Vi definerer personbiler som taxi, i forventning om at de personbiler som registreres i systemet blir det pga at de er taxi. Det ser ikke ut til å være noe data i Autosys som skiller ad en vanlig personbil og en taxi
            default -> AllPublicTransportModesEnumeration.OTHER;
        };
    }

    private PassengerCapacityStructure mapPassengerCapacity(Kjoretoydata vt, TekniskeData.Persontall pt, String dataOwner) {
        if(pt.getStaplasser() == null && pt.getSitteplasserTotalt() == null) return null;
        PassengerCapacityStructure passengerCapacityStructure = new PassengerCapacityStructure();
        passengerCapacityStructure.withId(passengerCapacityId(vt, dataOwner));
        passengerCapacityStructure.withVersion("1");

        if(pt.getSitteplasserTotalt() != null) passengerCapacityStructure.withSeatingCapacity(BigInteger.valueOf(pt.getSitteplasserTotalt()));
        if(pt.getStaplasser() != null) passengerCapacityStructure.withStandingCapacity(BigInteger.valueOf((pt.getStaplasser())));
        return passengerCapacityStructure;
    }

    private Boolean isLowFloor(Kode karosseritype) {
        if (karosseritype == null) {
            return null;
        }
        return switch (karosseritype.getKodeVerdi()) {
            case "CE", "CF", "CG", "CH", "CM", "CO", "CV" -> true;
            default -> false;
        };

    }

    private FuelTypeEnumeration mapFuelType(TekniskeData.MiljoOgdrivstoffGruppe dg) {
        return switch (dg.getDrivstoffKodeMiljodata().getKodeVerdi().toUpperCase()) {
            case "1" ->  // Bensin
                    FuelTypeEnumeration.PETROL;
            case "2" -> // Diesel
                    FuelTypeEnumeration.DIESEL;
            case "3" ->  // Parafin
                    FuelTypeEnumeration.OTHER;
            case "4" -> // Gass
                    FuelTypeEnumeration.LIQUID_GAS;
            case "13", "18", "19", "22" -> // CNG-gass
                    FuelTypeEnumeration.NATURAL_GAS;
            case "ELEKTRISK", "5" -> FuelTypeEnumeration.BATTERY;
            case "HYDROGEN", "6" -> FuelTypeEnumeration.HYDROGEN;
            case "7" -> FuelTypeEnumeration.PETROL_BATTERY_HYBRID;
            case "8" -> FuelTypeEnumeration.DIESEL_BATTERY_HYBRID;
            case "10" -> FuelTypeEnumeration.BIODIESEL;
            case "11" ->  // Biobensin ??
                    FuelTypeEnumeration.PETROL;
            case "12" -> // LPG
                    FuelTypeEnumeration.LIQUID_GAS;
            case "14" -> // Metanol
                    FuelTypeEnumeration.METHANE;
            case "15" -> // Etanol
                    FuelTypeEnumeration.ETHANOL; // LPG A
            case "16", "17" -> // LPG B
                    FuelTypeEnumeration.LIQUID_GAS;
            case "20" -> // Komprimert luft
                    FuelTypeEnumeration.OTHER;
            case "21" -> FuelTypeEnumeration.NATURAL_GAS;
            default -> FuelTypeEnumeration.OTHER;
        };

    }

    private PropulsionTypeEnumeration mapPropulsionType(TekniskeData.Motor md) {
        if(md.getArbeidsprinsipp() == null) return null;
        return switch (md.getArbeidsprinsipp().getKodeVerdi().toUpperCase()) {
            case "ELEKTRISK" -> PropulsionTypeEnumeration.ELECTRIC;
            case "ANNET" -> PropulsionTypeEnumeration.OTHER;
            case "DIESEL", "DIESEL_2_TAKTER", "DIESEL_4_TAKTER", "OTTO", "OTTO_2_TAKTER", "OTTO_4_TAKTER", "WANKEL" ->
                    PropulsionTypeEnumeration.COMBUSTION;
            default -> // "INGEN", annet
                    null;
        };
    }

    /// Make registration number to a basic form so it can be compared and sent to Autosys (remove whitespace and uppercase)
    public static String normalizeRegistrationNumber(String registrationNumber) {
        return registrationNumber == null ? null : registrationNumber.toUpperCase().replaceAll("[\\s\\p{Z}]+", "");
    }

    private String fallbackKey(Kjoretoydata vt) {
        var id = vt.getKjoretoyId();
        return id != null && id.getKjennemerke() != null ? id.getKjennemerke() : "UNKNOWN";
    }}
