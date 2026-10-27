package org.entur.shepet.mapping;

import org.entur.netex2.model.*;
import org.entur.shepet.mapping.util.ExportTimeZone;
import org.entur.shepet.mapping.util.PublicationDeliveryCreator;
import org.entur.shepet.mapping.util.SobekResourceFrameExporter;
import org.entur.shepet.model.*;
import org.entur.shepet.model.dto.VehicleBulkInputDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleBulkServiceTest {

    @Mock
    private PublicationDeliveryCreator publicationDeliveryCreator;

    @Mock
    private SobekResourceFrameExporter sobekResourceFrameExporter;

    @Mock
    private ExportTimeZone exportTimeZone;

    private MapperService mapperService;

    @BeforeEach
    void setUp() {
        mapperService = new MapperService(
                publicationDeliveryCreator,
                sobekResourceFrameExporter,
                exportTimeZone
        );

        // Setup default mocks
        when(publicationDeliveryCreator.createPublicationDelivery(any(ResourceFrame.class)))
                .thenReturn(new PublicationDeliveryStructure());
    }

    @Test
    void testDataOwnerIsCorrectlyAddedToFrame() {
        // Arrange
        String dataOwner = "TEST:Authority:123";
        List<Kjoretoydata> vehicles = List.of(createKjoretoydata("ABC123", "TYPE001"));
        List<VehicleBulkInputDto> inputs = List.of();

        ResourceFrame capturedFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame(dataOwner)).thenReturn(capturedFrame);

        // Act
        PublicationDeliveryStructure result = mapperService.exportPublicationDeliveryWithAutosysVehicle(
                vehicles, List.of(), dataOwner, inputs);

        // Assert
        assertNotNull(result);
        // Verify that createResourceFrame was called with the correct dataOwner
        org.mockito.Mockito.verify(sobekResourceFrameExporter).createResourceFrame(dataOwner);
    }

    @Test
    void testVehicleTypesAreDeduplicatedCorrectly() {
        // Arrange - Create 3 vehicles with 2 different vehicle types (TYPE001 appears twice)
        List<Kjoretoydata> vehicles = List.of(
                createKjoretoydata("ABC123", "TYPE001"),
                createKjoretoydata("DEF456", "TYPE001"), // Same type as ABC123
                createKjoretoydata("GHI789", "TYPE002")
        );
        List<VehicleBulkInputDto> inputs = List.of();

        ResourceFrame resourceFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame("TEST")).thenReturn(resourceFrame);

        // Act
        mapperService.exportPublicationDeliveryWithAutosysVehicle(vehicles, List.of(), "TEST", inputs);

        // Assert
        VehicleTypesInFrame_RelStructure vehicleTypes = resourceFrame.getVehicleTypes();
        assertNotNull(vehicleTypes);
        assertNotNull(vehicleTypes.getTransportType());

        // Extract actual VehicleType objects from JAXBElements
        List<VehicleType> actualVehicleTypes = vehicleTypes.getTransportType().stream()
                .filter(jaxb -> jaxb.getValue() instanceof VehicleType)
                .map(jaxb -> (VehicleType) jaxb.getValue())
                .toList();

        assertEquals(2, actualVehicleTypes.size(), "Should have 2 unique vehicle types, not 3");

        // Verify the IDs are correct
        assertTrue(actualVehicleTypes.stream().anyMatch(vt -> vt.getId().contains("TYPE001")));
        assertTrue(actualVehicleTypes.stream().anyMatch(vt -> vt.getId().contains("TYPE002")));
    }

    @Test
    void testVehicleModelsAreDeduplicatedCorrectly() {
        // Arrange - Create 3 vehicles with 2 different models (MODEL001 appears twice)
        List<Kjoretoydata> vehicles = List.of(
                createKjoretoydata("ABC123", "MODEL001"),
                createKjoretoydata("DEF456", "MODEL001"), // Same model as ABC123
                createKjoretoydata("GHI789", "MODEL002")
        );
        List<VehicleBulkInputDto> inputs = List.of();

        ResourceFrame resourceFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame("TEST")).thenReturn(resourceFrame);

        // Act
        mapperService.exportPublicationDeliveryWithAutosysVehicle(vehicles, List.of(),"TEST", inputs);

        // Assert
        VehicleModelsInFrame_RelStructure vehicleModels = resourceFrame.getVehicleModels();
        assertNotNull(vehicleModels);
        assertNotNull(vehicleModels.getVehicleModel());
        assertEquals(2, vehicleModels.getVehicleModel().size(),
                "Should have 2 unique vehicle models, not 3");

        // Verify the IDs are correct
        assertTrue(vehicleModels.getVehicleModel().stream()
                .anyMatch(vm -> vm.getId().contains("MODEL001")));
        assertTrue(vehicleModels.getVehicleModel().stream()
                .anyMatch(vm -> vm.getId().contains("MODEL002")));
    }

    @Test
    void testOperationalNumberIsAddedToVehicles() {
        // Arrange
        List<Kjoretoydata> vehicles = List.of(
                createKjoretoydata("ABC123", "TYPE001"),
                createKjoretoydata("DEF456", "TYPE002")
        );

        List<VehicleBulkInputDto> inputs = List.of(
                createVehicleInput("ABC123", "OP-001"),
                createVehicleInput("DEF456", "OP-002")
        );

        ResourceFrame resourceFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame("TEST")).thenReturn(resourceFrame);

        // Act
        mapperService.exportPublicationDeliveryWithAutosysVehicle(vehicles, List.of(),"TEST", inputs);

        // Assert
        VehiclesInFrame_RelStructure vehiclesInFrame = resourceFrame.getVehicles();
        assertNotNull(vehiclesInFrame);
        assertNotNull(vehiclesInFrame.getVehicle());
        assertEquals(2, vehiclesInFrame.getVehicle().size());

        // Check that operational numbers are set correctly
        Vehicle vehicle1 = vehiclesInFrame.getVehicle().stream()
                .filter(v -> "ABC123".equals(v.getRegistrationNumber()))
                .findFirst()
                .orElse(null);
        assertNotNull(vehicle1);
        assertEquals("OP-001", vehicle1.getOperationalNumber());

        Vehicle vehicle2 = vehiclesInFrame.getVehicle().stream()
                .filter(v -> "DEF456".equals(v.getRegistrationNumber()))
                .findFirst()
                .orElse(null);
        assertNotNull(vehicle2);
        assertEquals("OP-002", vehicle2.getOperationalNumber());
    }

    @Test
    void testMultipleInputsWithSameRegistrationPicksFirst() {
        // Arrange
        List<Kjoretoydata> vehicles = List.of(createKjoretoydata("ABC123", "TYPE001"));

        List<VehicleBulkInputDto> inputs = List.of(
                createVehicleInput("ABC123", "OP-FIRST"),
                createVehicleInput("ABC123", "OP-SECOND") // Duplicate - should be ignored
        );

        ResourceFrame resourceFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame("TEST")).thenReturn(resourceFrame);

        // Act
        mapperService.exportPublicationDeliveryWithAutosysVehicle(vehicles, List.of(),"TEST", inputs);

        // Assert
        VehiclesInFrame_RelStructure vehiclesInFrame = resourceFrame.getVehicles();
        assertNotNull(vehiclesInFrame);

        Vehicle vehicle = vehiclesInFrame.getVehicle().getFirst();
        assertEquals("OP-FIRST", vehicle.getOperationalNumber(),
                "Should use the first operational number when there are duplicates");
    }

    @Test
    void testVehicleWithoutOperationalNumberInput() {
        // Arrange
        List<Kjoretoydata> vehicles = List.of(createKjoretoydata("ABC123", "TYPE001"));
        List<VehicleBulkInputDto> inputs = List.of(); // No inputs with operational numbers

        ResourceFrame resourceFrame = new ResourceFrame();
        when(sobekResourceFrameExporter.createResourceFrame("TEST")).thenReturn(resourceFrame);

        // Act
        mapperService.exportPublicationDeliveryWithAutosysVehicle(vehicles, List.of(),"TEST", inputs);

        // Assert
        VehiclesInFrame_RelStructure vehiclesInFrame = resourceFrame.getVehicles();
        assertNotNull(vehiclesInFrame);

        Vehicle vehicle = vehiclesInFrame.getVehicle().getFirst();
        assertNull(vehicle.getOperationalNumber(),
                "Operational number should be null when no input is provided");
    }

    // Helper methods
    private Kjoretoydata createKjoretoydata(String registrationNumber, String typeApprovalNumber) {
        Kjoretoydata kjoretoydata = new Kjoretoydata();

        KjoretoyId kjoretoyId = new KjoretoyId();
        kjoretoyId.setKjennemerke(registrationNumber);
        kjoretoyId.setUnderstellsnummer("VIN" + registrationNumber);
        kjoretoydata.setKjoretoyId(kjoretoyId);

        Godkjenning godkjenning = new Godkjenning();
        TekniskGodkjenning tekniskGodkjenning = new TekniskGodkjenning();
        TekniskGodkjenning.Kjoretoyklassifisering klassifisering = new TekniskGodkjenning.Kjoretoyklassifisering();
        TekniskGodkjenning.EfTypegodkjenning efTypegodkjenning = new TekniskGodkjenning.EfTypegodkjenning();
        efTypegodkjenning.setTypegodkjenningNrTekst(typeApprovalNumber);
        klassifisering.setEfTypegodkjenning(efTypegodkjenning);
        tekniskGodkjenning.setKjoretoyklassifisering(klassifisering);
        godkjenning.setTekniskGodkjenning(tekniskGodkjenning);
        kjoretoydata.setGodkjenning(godkjenning);

        return kjoretoydata;
    }

    private VehicleBulkInputDto createVehicleInput(String registrationNumber, String operationalNumber) {
        return new VehicleBulkInputDto(registrationNumber, operationalNumber);
    }
}