package org.entur.shepet.mapping;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import org.entur.shepet.model.Kjoretoydata;
import org.entur.shepet.model.Kode;
import org.entur.shepet.model.TekniskeData;
import org.rutebanken.netex.model.*;
import org.rutebanken.sobek.exporter.PublicationDeliveryCreator;
import org.rutebanken.sobek.exporter.SobekComositeFrameExporter;
import org.rutebanken.sobek.exporter.SobekResourceFrameExporter;
import org.rutebanken.sobek.netex.util.KeyValuesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBElement;

@Service
public class MapperService {
    private static final Logger logger = LoggerFactory.getLogger(MapperService.class);
    private final SobekResourceFrameExporter sobekResourceFrameExporter;
    private final SobekComositeFrameExporter sobekComositeFrameExporter;
    private final PublicationDeliveryCreator publicationDeliveryCreator;
    private static final ObjectFactory netexObjectFactory = new ObjectFactory();

    public MapperService(PublicationDeliveryCreator publicationDeliveryCreator,
                                            SobekResourceFrameExporter sobekResourceFrameExporter,
                                            SobekComositeFrameExporter sobekComositeFrameExporter) {
        this.publicationDeliveryCreator = publicationDeliveryCreator;
        this.sobekResourceFrameExporter = sobekResourceFrameExporter;
        this.sobekComositeFrameExporter = sobekComositeFrameExporter;
    }

    public PublicationDeliveryStructure exportPublicationDeliveryWithAutosysVehicle(List<Kjoretoydata> kjoretoyList) {
        logger.info("Preparing publication delivery export");

        final CompositeFrame netexCompositeFrame = sobekComositeFrameExporter.createCompositeFrame("Composite frame ");
        final ResourceFrame netexResourceFrame = sobekResourceFrameExporter.createResourceFrame("Resource frame ");

        Frames_RelStructure framesRelStructure = new Frames_RelStructure();
        framesRelStructure.withCommonFrame(new ObjectFactory().createResourceFrame(netexResourceFrame));
        netexCompositeFrame.withFrames(framesRelStructure);

        logger.info("Preparing scrollable iterators");
        prepareVehicleTypes(kjoretoyList, netexResourceFrame);
        prepareVehicleModels(kjoretoyList,  netexResourceFrame);
        prepareDeckPlans(kjoretoyList, netexResourceFrame);
        prepareVehicles(kjoretoyList, netexResourceFrame);

        return publicationDeliveryCreator.createPublicationDelivery(netexCompositeFrame);
    }

    private void prepareDeckPlans(List<Kjoretoydata> kjoretoyList, org.rutebanken.netex.model.ResourceFrame netexResourceFrame) {
        if (!kjoretoyList.isEmpty()) {
            logger.info("There are deck plans to export");

            DeckPlans_RelStructure deckPlansRelStructure = new DeckPlans_RelStructure();
            List<org.rutebanken.netex.model.DeckPlan> deckPlans = kjoretoyList.stream().map(vt -> {
                return new org.rutebanken.netex.model.DeckPlan()
                        .withId(deckPlanId(vt, kjoretoyList.indexOf(vt)))
                        .withVersion("1")
                        .withName(createMultilingualString(deckPlanName(vt)))
                        .withDescription(createMultilingualString(deckPlanDescription(vt)));
            }).toList();

            setField(DeckPlans_RelStructure.class, "deckPlan", deckPlansRelStructure, deckPlans);
            netexResourceFrame.setDeckPlans(deckPlansRelStructure);
        } else {
            logger.info("No deck plans to export");
        }

    }

    private String deckPlanName(Kjoretoydata vt) {
        if (vt.getGodkjenning() == null) return "";
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return "";
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return "";
        var tekniskeData = tekniskGodkjenning.getTekniskeData();
        if(tekniskeData == null) return "";
        var kaorsseriOgLasteplan = tekniskeData.getKarosseriOgLasteplan();
        if(kaorsseriOgLasteplan == null) return "";
        var karosseriType = kaorsseriOgLasteplan.getKarosseritype();
        if(karosseriType == null) return "";
        return karosseriType.getKodeNavn();
    }

    private void prepareVehicleModels(List<Kjoretoydata> kjoretoyList, org.rutebanken.netex.model.ResourceFrame resourceFrame) {

        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicle models to export");

            VehicleModelsInFrame_RelStructure vehicleModelsInFrameRelStructure = new VehicleModelsInFrame_RelStructure();
            List<org.rutebanken.netex.model.VehicleModel> vehicleModels = kjoretoyList.stream().map(vt -> {
                return new org.rutebanken.netex.model.VehicleModel()
                        .withId(vehicleModelId(vt, kjoretoyList.indexOf(vt)))
                        .withVersion("1")
                        .withDescription(createMultilingualString(modelDescription(vt)));
                }).toList();

            setField(VehicleModelsInFrame_RelStructure.class, "vehicleModel", vehicleModelsInFrameRelStructure, vehicleModels);
            resourceFrame.setVehicleModels(vehicleModelsInFrameRelStructure);
        } else {
            logger.info("No vehicle models to export");
        }
    }

    private MultilingualString createMultilingualString(String vt) {
        return new MultilingualString().withContent(List.of(createTextType(vt)));
    }

    private JAXBElement<? extends TextType> createTextType (String value){
        return netexObjectFactory.createMultilingualStringText(new TextType()
                .withValue(value));
    }

    private String deckPlanDescription(Kjoretoydata vt) {
        if (vt.getGodkjenning() == null) return "";
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return "";
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return "";
        var tekniskeData = tekniskGodkjenning.getTekniskeData();
        if(tekniskeData == null) return "";
        var kaorsseriOgLasteplan = tekniskeData.getKarosseriOgLasteplan();
        if(kaorsseriOgLasteplan == null) return "";
        var karosseriType = kaorsseriOgLasteplan.getKarosseritype();
        if(karosseriType == null) return "";
        var generelt = tekniskeData.getGenerelt();
        if(generelt == null) return "";
        var merker = generelt.getMerke();
        if(merker == null || merker.isEmpty()) return "";
        var merke = merker.getFirst();
        var handelsbetegnelse = generelt.getHandelsbetegnelse();
        return merke.getMerke() + (handelsbetegnelse == null || handelsbetegnelse.isEmpty() ? "" : " "  + handelsbetegnelse.getFirst()) + " - " + karosseriType.getKodeNavn();
    }

    private String deckPlanId(Kjoretoydata vt, int index) {
        if (vt.getGodkjenning() == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var kjoretoyklassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if (kjoretoyklassifisering.getEfTypegodkjenning() == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var efTypegodkjenning = kjoretoyklassifisering.getEfTypegodkjenning();
        if (efTypegodkjenning.getTypegodkjenningNrTekst() == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var tekniskeData = tekniskGodkjenning.getTekniskeData();
        if(tekniskeData == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var kaorsseriOgLasteplan = tekniskeData.getKarosseriOgLasteplan();
        if(kaorsseriOgLasteplan == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        var karosseriType = kaorsseriOgLasteplan.getKarosseritype();
        if(karosseriType == null) return String.format("AUTOSYS:DeckPlan:%d", index);
        return String.format("AUTOSYS:DeckPlan:%s", efTypegodkjenning.getTypegodkjenningNrTekst() + "-" + karosseriType.getKodeVerdi());
    }

    private String vehicleModelId(Kjoretoydata vt, int index) {
        if (vt.getGodkjenning() == null) return String.format("AUTOSYS:VehicleModel:%d", index);
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return String.format("AUTOSYS:VehicleModel:%d", index);
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return String.format("AUTOSYS:VehicleModel:%d", index);
        var kjoretoyklassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if (kjoretoyklassifisering.getEfTypegodkjenning() == null) return String.format("AUTOSYS:VehicleModel:%d", index);
        var efTypegodkjenning = kjoretoyklassifisering.getEfTypegodkjenning();
        if (efTypegodkjenning.getTypegodkjenningNrTekst() == null) return String.format("AUTOSYS:VehicleModel:%d", index);
        return String.format("AUTOSYS:VehicleModel:%s", efTypegodkjenning.getTypegodkjenningNrTekst());
    }

    private String vehicleTypeId(Kjoretoydata vt, int index) {
        if (vt.getGodkjenning() == null) return String.format("AUTOSYS:VehicleType:%d", index);
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return String.format("AUTOSYS:VehicleType:%d", index);
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return String.format("AUTOSYS:VehicleType:%d", index);
        var kjoretoyklassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if (kjoretoyklassifisering.getEfTypegodkjenning() == null) return String.format("AUTOSYS:VehicleType:%d", index);
        var efTypegodkjenning = kjoretoyklassifisering.getEfTypegodkjenning();
        if (efTypegodkjenning.getTypegodkjenningNrTekst() == null) return String.format("AUTOSYS:VehicleType:%d", index);
        return String.format("AUTOSYS:VehicleType:%s", efTypegodkjenning.getTypegodkjenningNrTekst());
    }

    private String passengerCapacityId(Kjoretoydata vt, int index) {
        if (vt.getGodkjenning() == null) return String.format("AUTOSYS:PassengerCapacity:%d", index);
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return String.format("AUTOSYS:PassengerCapacity:%d", index);
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if (tekniskGodkjenning.getKjoretoyklassifisering() == null) return String.format("AUTOSYS:PassengerCapacity:%d", index);
        var kjoretoyklassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if (kjoretoyklassifisering.getEfTypegodkjenning() == null) return String.format("AUTOSYS:PassengerCapacity:%d", index);
        var efTypegodkjenning = kjoretoyklassifisering.getEfTypegodkjenning();
        if (efTypegodkjenning.getTypegodkjenningNrTekst() == null) return String.format("AUTOSYS:PassengerCapacity:%d", index);
        return String.format("AUTOSYS:PassengerCapacity:%s", efTypegodkjenning.getTypegodkjenningNrTekst());
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

    private void prepareVehicles(List<Kjoretoydata> kjoretoyList, org.rutebanken.netex.model.ResourceFrame resourceFrame) {
        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicles to export");

            VehiclesInFrame_RelStructure vehiclesInFrame_relStructure = new VehiclesInFrame_RelStructure();

            List<org.rutebanken.netex.model.Vehicle> vehicles = kjoretoyList.stream().map(kjoretoy -> {
                return new org.rutebanken.netex.model.Vehicle()
                        .withChassisNumber(kjoretoy.getKjoretoyId().getUnderstellsnummer())
                        .withRegistrationNumber(kjoretoy.getKjoretoyId().getKjennemerke())
                        .withId("AUTOSYS:Vehicle:" + kjoretoy.getKjoretoyId().getKjennemerke())
                        .withVersion("1")
                        .withTransportTypeRef(createVechicleTypeRef(kjoretoy, kjoretoyList.indexOf(kjoretoy)))
                        .withVehicleModelRef(createModelRef(kjoretoy, kjoretoyList.indexOf(kjoretoy)))
                        .withRegistrationDate(kjoretoy.getRegistrering().getFomTidspunkt().toLocalDateTime());
            }).toList();

            setField(VehiclesInFrame_RelStructure.class, "vehicle", vehiclesInFrame_relStructure, vehicles);
            resourceFrame.setVehicles(vehiclesInFrame_relStructure);
        } else {
            logger.info("No vehicles to export");
        }
    }

    private VehicleModelRefStructure createModelRef(Kjoretoydata vt, int index) {
        VehicleModelRefStructure vehicleModelRefStructure = new VehicleModelRefStructure();
        vehicleModelRefStructure.setRef(vehicleModelId(vt, index));
        return vehicleModelRefStructure;
    }

    private JAXBElement<? extends TransportTypeRefStructure> createVechicleTypeRef(Kjoretoydata vt, int index) {
        TransportTypeRefStructure transportTypeRefStructure = new TransportTypeRefStructure();
        transportTypeRefStructure.setRef(vehicleTypeId(vt, index));
        return netexObjectFactory.createTransportTypeRef(transportTypeRefStructure);
    }

    private DeckPlanRefStructure createDeckPlanRef(Kjoretoydata vt, int index) {
        DeckPlanRefStructure deckPlanRefStructure  = new DeckPlanRefStructure();
        deckPlanRefStructure.setRef(deckPlanId(vt, index));
        return deckPlanRefStructure;
    }

    private void prepareVehicleTypes(List<Kjoretoydata> kjoretoyList, org.rutebanken.netex.model.ResourceFrame resourceFrame) {
        // Override lists with custom iterator to be able to scroll database results on the fly.
        if (!kjoretoyList.isEmpty()) {
            logger.info("There are vehicle types to export");

            VehicleTypesInFrame_RelStructure vehicleTypesInFrameRelStructure = new VehicleTypesInFrame_RelStructure();
            List<org.rutebanken.netex.model.VehicleType> vehicleTypes = kjoretoyList.stream().map(vt -> {
                return mapOneVehicleType(vt, kjoretoyList.indexOf(vt));
            }).toList();

            List<JAXBElement<org.rutebanken.netex.model.VehicleType>> jaxbVehicleTypes = vehicleTypes.stream().map(vt -> new ObjectFactory().createVehicleType(vt)).toList();
            setField(VehicleTypesInFrame_RelStructure.class, "transportType_Dummy", vehicleTypesInFrameRelStructure, jaxbVehicleTypes);
            resourceFrame.setVehicleTypes(vehicleTypesInFrameRelStructure);
        } else {
            logger.info("No vehicle types to export");
        }
    }

    private VehicleType mapOneVehicleType(Kjoretoydata vt, int index) {
        var vehicleType = new org.rutebanken.netex.model.VehicleType()
                .withId(vehicleTypeId(vt, index))
                .withDeckPlanRef(createDeckPlanRef(vt, index))
                .withVersion("1");

        if (vt.getGodkjenning() == null) return vehicleType;
        var godkjenning = vt.getGodkjenning();
        if (godkjenning.getTekniskGodkjenning() == null) return vehicleType;
        var tekniskGodkjenning = godkjenning.getTekniskGodkjenning();
        if(tekniskGodkjenning.getKjoretoyklassifisering() == null) return vehicleType;
        var kjoretoyKlassifisering = tekniskGodkjenning.getKjoretoyklassifisering();
        if(kjoretoyKlassifisering.getTekniskKode() == null) return vehicleType;
        var tekniskKode = kjoretoyKlassifisering.getTekniskKode();
        vehicleType.setTransportMode(mapTransportMode(vt, tekniskKode));

        if (tekniskGodkjenning.getTekniskeData() == null) return vehicleType;
        var tekniskeData = tekniskGodkjenning.getTekniskeData();

        if(tekniskeData.getPersontall() != null) {
            var passengerCapacityStructure = mapPassengerCapacity(vt, index, tekniskeData.getPersontall());
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
            if(miljoData.getEuroKlasse() != null) vehicleType.withEuroClass(miljoData.getEuroKlasse().getKodeVerdi());
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
                    KeyValuesHelper.AddToKeyValues(vehicleType, "MaximumEngineEffectKW", totalMaksNettoEffekt.toString());
                }
            }
            if(motorOgDrivverk.getHybridKategori() != null) {
                if(motorOgDrivverk.getHybridKategori().getKodeVerdi().equals("LADBAR")) {
                    KeyValuesHelper.AddToKeyValues(vehicleType, "HybridCategory", "Chargeable");
                } else if(motorOgDrivverk.getHybridKategori().getKodeVerdi().equals("IKKE_LADBAR")) {
                    KeyValuesHelper.AddToKeyValues(vehicleType, "HybridCategory", "NonChargeable");
                }
            }
        }

        if (tekniskeData.getKarosseriOgLasteplan() != null && tekniskeData.getKarosseriOgLasteplan().getKarosseritype() != null) {
            vehicleType.withLowFloor(isLowFloor(tekniskeData.getKarosseriOgLasteplan().getKarosseritype()));
        }

        return vehicleType;
    }

    private AllPublicTransportModesEnumeration mapTransportMode(Kjoretoydata vt, Kode tekniskKode) {
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

    private PassengerCapacityStructure mapPassengerCapacity(Kjoretoydata vt, int index, TekniskeData.Persontall pt) {
        if(pt.getStaplasser() == null && pt.getSitteplasserTotalt() == null) return null;
        PassengerCapacityStructure passengerCapacityStructure = new PassengerCapacityStructure();
        passengerCapacityStructure.withId(passengerCapacityId(vt, index));
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

    /**
     * Set field value with reflection.
     * Used for setting list values in netex model.
     */
    private void setField(Class clazz, String fieldName, Object instance, Object fieldValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, fieldValue);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException("Cannot set field " + fieldName + " of " + instance, e);
        }
    }

}
