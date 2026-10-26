
package org.entur.shepet.rest.netex.publicationdelivery;

import jakarta.ws.rs.core.Response;
import org.entur.netex2.model.PublicationDeliveryStructure;
import org.entur.shepet.mapping.MapperService;
import org.entur.shepet.model.Kjoretoydata;
import org.entur.shepet.model.KjoretoyId;
import org.entur.shepet.model.dto.BulkResultDto;
import org.entur.shepet.model.dto.FetchVehicleErrorDto;
import org.entur.shepet.model.dto.VehicleBulkInputDto;
import org.entur.shepet.service.ShepetService;
import org.entur.shepet.service.VehicleBulkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutosysAPIResourceTest {

    @Mock
    private ShepetService shepetService;

    @Mock
    private VehicleBulkService vehicleBulkService;

    @Mock
    private MapperService mapperService;

    @Mock
    private PublicationDeliveryStreamingOutput publicationDeliveryStreamingOutput;

    private AutosysAPIResource autosysAPIResource;

    @BeforeEach
    void setUp() {
        autosysAPIResource = new AutosysAPIResource(
                publicationDeliveryStreamingOutput,
                shepetService,
                vehicleBulkService,
                mapperService
        );
    }

    @Test
    void testGetVehiclesFromAutosys_WithMixedSuccessAndFailure() throws Exception {
        // Arrange
        String dataOwner = "TEST:Authority:123";
        VehicleBulkInputDto successInput = createVehicleInput("ABC123", "OP-001");
        VehicleBulkInputDto failureInput = createVehicleInput("XYZ999", "OP-002");
        List<VehicleBulkInputDto> inputs = List.of(successInput, failureInput);

        // Create successful vehicle data
        Kjoretoydata successVehicle = createKjoretoydata("ABC123");

        // Create error for failed vehicle
        FetchVehicleErrorDto fetchError = new FetchVehicleErrorDto("Failed to fetch vehicle: Vehicle not found", "XYZ999");

        // Mock the bulk service to return one success and one error
        BulkResultDto fetchResults =
                new BulkResultDto(List.of(successVehicle), List.of(fetchError));
        when(vehicleBulkService.fetchAndDeduplicateVehicles(inputs)).thenReturn(fetchResults);

        // Mock mapper service
        PublicationDeliveryStructure mockDelivery = new PublicationDeliveryStructure();
        when(mapperService.exportPublicationDeliveryWithAutosysVehicle(
                anyList(), anyList(), eq(dataOwner), eq(inputs)
        )).thenReturn(mockDelivery);

        // Act
        Response response = autosysAPIResource.getVehiclesFromAutosys(inputs, dataOwner);

        // Assert
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Verify that vehicleBulkService was called with correct inputs
        verify(vehicleBulkService).fetchAndDeduplicateVehicles(inputs);

        // Verify that mapperService was called with both successful vehicles and errors
        verify(mapperService).exportPublicationDeliveryWithAutosysVehicle(
                eq(List.of(successVehicle)),
                eq(List.of(fetchError)),
                eq(dataOwner),
                eq(inputs)
        );

        // Verify that streaming output was called
        verify(publicationDeliveryStreamingOutput).stream(mockDelivery);
    }

    @Test
    void testGetVehiclesFromAutosys_AllVehiclesFail() throws Exception {
        // Arrange
        String dataOwner = "TEST:Authority:456";
        VehicleBulkInputDto input1 = createVehicleInput("FAIL001", "OP-001");
        VehicleBulkInputDto input2 = createVehicleInput("FAIL002", "OP-002");
        List<VehicleBulkInputDto> inputs = List.of(input1, input2);

        // Create errors for both vehicles
        FetchVehicleErrorDto error1 = new FetchVehicleErrorDto("Failed to fetch vehicle: Connection timeout", "FAIL001");

        FetchVehicleErrorDto error2 = new FetchVehicleErrorDto("Failed to fetch vehicle: Invalid registration number", "FAIL002");

        // Mock the bulk service to return no successes and two errors
        BulkResultDto fetchResults =
                new BulkResultDto(List.of(), List.of(error1, error2));
        when(vehicleBulkService.fetchAndDeduplicateVehicles(anyList())).thenReturn(fetchResults);

        // Mock mapper service
        PublicationDeliveryStructure mockDelivery = new PublicationDeliveryStructure();
        when(mapperService.exportPublicationDeliveryWithAutosysVehicle(
                anyList(), anyList(), eq(dataOwner), eq(inputs)
        )).thenReturn(mockDelivery);

        // Act
        Response response = autosysAPIResource.getVehiclesFromAutosys(inputs, dataOwner);

        // Assert
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Verify that mapperService was called with no vehicles but with both errors
        verify(mapperService).exportPublicationDeliveryWithAutosysVehicle(
                eq(List.of()),
                eq(List.of(error1, error2)),
                eq(dataOwner),
                eq(inputs)
        );
    }

    @Test
    void testGetVehiclesFromAutosys_MultipleVehiclesOnePartialFailure() throws Exception {
        // Arrange
        String dataOwner = "TEST:Authority:789";
        VehicleBulkInputDto input1 = createVehicleInput("ABC123", "OP-001");
        VehicleBulkInputDto input2 = createVehicleInput("DEF456", "OP-002");
        VehicleBulkInputDto input3 = createVehicleInput("FAIL999", "OP-003");
        List<VehicleBulkInputDto> inputs = List.of(input1, input2, input3);

        // Create successful vehicles
        Kjoretoydata vehicle1 = createKjoretoydata("ABC123");
        Kjoretoydata vehicle2 = createKjoretoydata("DEF456");

        // Create error for one vehicle
        FetchVehicleErrorDto error = new FetchVehicleErrorDto("Failed to fetch vehicle: Service unavailable", "FAIL999");

        // Mock the bulk service to return two successes and one error
        BulkResultDto fetchResults =
                new BulkResultDto(List.of(vehicle1, vehicle2), List.of(error));
        when(vehicleBulkService.fetchAndDeduplicateVehicles(inputs)).thenReturn(fetchResults);

        // Mock mapper service
        PublicationDeliveryStructure mockDelivery = new PublicationDeliveryStructure();
        when(mapperService.exportPublicationDeliveryWithAutosysVehicle(
                anyList(), anyList(), eq(dataOwner), eq(inputs)
        )).thenReturn(mockDelivery);

        // Act
        Response response = autosysAPIResource.getVehiclesFromAutosys(inputs, dataOwner);

        // Assert
        assertNotNull(response);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        // Verify that mapperService was called with 2 successful vehicles and 1 error
        verify(mapperService).exportPublicationDeliveryWithAutosysVehicle(
                eq(List.of(vehicle1, vehicle2)),
                eq(List.of(error)),
                eq(dataOwner),
                eq(inputs)
        );
    }

    @Test
    void testGetVehiclesFromAutosys_EmptyInputList() throws Exception {
        // Arrange
        String dataOwner = "TEST:Authority:000";
        List<VehicleBulkInputDto> inputs = List.of();

        // Act
        Response response = autosysAPIResource.getVehiclesFromAutosys(inputs, dataOwner);

        // Assert
        assertNotNull(response);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        assertEquals("Vehicle import list cannot be empty", response.getEntity());

        // Verify that services were not called
        verifyNoInteractions(vehicleBulkService);
        verifyNoInteractions(mapperService);
        verifyNoInteractions(publicationDeliveryStreamingOutput);
    }

    @Test
    void testGetVehiclesFromAutosys_NullInputList() throws Exception {
        // Arrange
        String dataOwner = "TEST:Authority:000";

        // Act
        Response response = autosysAPIResource.getVehiclesFromAutosys(null, dataOwner);

        // Assert
        assertNotNull(response);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
        assertEquals("Vehicle import list cannot be empty", response.getEntity());

        // Verify that services were not called
        verifyNoInteractions(vehicleBulkService);
        verifyNoInteractions(mapperService);
        verifyNoInteractions(publicationDeliveryStreamingOutput);
    }

    // Helper methods
    private VehicleBulkInputDto createVehicleInput(String registrationNumber, String operationalNumber) {
        return new VehicleBulkInputDto(registrationNumber, operationalNumber);
    }

    private Kjoretoydata createKjoretoydata(String registrationNumber) {
        Kjoretoydata kjoretoydata = new Kjoretoydata();
        KjoretoyId kjoretoyId = new KjoretoyId();
        kjoretoyId.setKjennemerke(registrationNumber);
        kjoretoyId.setUnderstellsnummer("VIN" + registrationNumber);
        kjoretoydata.setKjoretoyId(kjoretoyId);
        return kjoretoydata;
    }
}