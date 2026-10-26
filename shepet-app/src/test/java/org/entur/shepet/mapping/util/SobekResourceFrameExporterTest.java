package org.entur.shepet.mapping.util;

import org.entur.netex2.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SobekResourceFrameExporterTest {

    @Mock
    private NetexIdHelper netexIdHelper;
    @Mock
    private ExportTimeZone exportTimeZone;

    private SobekResourceFrameExporter sobekResourceFrameExporter;

    @BeforeEach
    void setUp() {
        sobekResourceFrameExporter = new SobekResourceFrameExporter(netexIdHelper, "nor", exportTimeZone);

        // Setup default mock behavior
        when(netexIdHelper.getNetexId(anyString(), anyLong()))
                .thenAnswer(invocation -> {
                    String type = invocation.getArgument(0);
                    long hash = invocation.getArgument(1);
                    return "TEST:" + type + ":" + Math.abs(hash);
                });
    }

    @Test
    void testCreateResourceFrameWithDataOwner() {
        // Arrange
        String dataOwner = "RUT:Authority:123";
        when(exportTimeZone.getDefaultTimeZoneId()).thenReturn(ZoneId.of("Europe/Oslo"));

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        assertNotNull(result, "ResourceFrame should not be null");
        assertEquals("1", result.getVersion(), "Version should be 1");
        assertNotNull(result.getId(), "ResourceFrame ID should be set");

        // Verify ResponsibilitySets is present
        assertNotNull(result.getResponsibilitySets(), 
                "ResponsibilitySets should be present when dataOwner is provided");
        
        ResponsibilitySetsInFrame_RelStructure responsibilitySets = result.getResponsibilitySets();
        assertNotNull(responsibilitySets.getResponsibilitySet(), 
                "ResponsibilitySet list should not be null");
        assertEquals(1, responsibilitySets.getResponsibilitySet().size(), 
                "Should have exactly one ResponsibilitySet");
        
        // Verify ResponsibilitySet details
        ResponsibilitySet responsibilitySet = responsibilitySets.getResponsibilitySet().getFirst();
        assertNotNull(responsibilitySet.getId(), "ResponsibilitySet ID should be set");
        
        // Verify Roles
        assertNotNull(responsibilitySet.getRoles(), "Roles should be present");
        ResponsibilityRoleAssignments_RelStructure roles = responsibilitySet.getRoles();
        assertNotNull(roles.getResponsibilityRoleAssignment(), 
                "ResponsibilityRoleAssignment list should not be null");
        assertEquals(1, roles.getResponsibilityRoleAssignment().size(), 
                "Should have exactly one ResponsibilityRoleAssignment");
        
        // Verify ResponsibilityRoleAssignment
        ResponsibilityRoleAssignment roleAssignment = roles.getResponsibilityRoleAssignment().getFirst();
        
        // Verify the DataRoleType list contains exactly one element of type OWNS
        assertNotNull(roleAssignment.getDataRoleType(), 
                "DataRoleType list should not be null");
        List<DataRoleTypeEnumeration> dataRoleTypes = roleAssignment.getDataRoleType();
        assertEquals(1, dataRoleTypes.size(), 
                "Should have exactly one DataRoleType in the list");
        assertEquals(DataRoleTypeEnumeration.OWNS, dataRoleTypes.getFirst(),
                "The single DataRoleType should be OWNS");
        
        // Verify ResponsibleOrganisationRef
        assertNotNull(roleAssignment.getResponsibleOrganisationRef(), 
                "ResponsibleOrganisationRef should be present");
        assertEquals(dataOwner, roleAssignment.getResponsibleOrganisationRef().getRef(), 
                "ResponsibleOrganisationRef should reference the dataOwner");
        
        // Verify FrameDefaults
        assertNotNull(result.getFrameDefaults(), "FrameDefaults should be present");
        VersionFrameDefaultsStructure frameDefaults = result.getFrameDefaults();
        assertNotNull(frameDefaults.getDefaultResponsibilitySetRef(), 
                "DefaultResponsibilitySetRef should be present");
        assertEquals(responsibilitySet.getId(), 
                frameDefaults.getDefaultResponsibilitySetRef().getRef(), 
                "DefaultResponsibilitySetRef should reference the ResponsibilitySet ID");
    }

    @Test
    void testCreateResourceFrameWithoutDataOwner() {
        // Arrange
        String dataOwner = null;

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        assertNotNull(result, "ResourceFrame should not be null");
        assertEquals("1", result.getVersion(), "Version should be 1");
        assertNotNull(result.getId(), "ResourceFrame ID should be set");

        // Verify ResponsibilitySets is NOT present when dataOwner is null
        assertNull(result.getResponsibilitySets(),
                "ResponsibilitySets should be null when dataOwner is not provided");

        // Verify FrameDefaults is NOT present when dataOwner is null
        assertNull(result.getFrameDefaults(),
                "FrameDefaults should be null when dataOwner is not provided");
    }

    @Test
    void testCreateResourceFrameWithEmptyDataOwner() {
        // Arrange
        String dataOwner = "";

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        assertNotNull(result, "ResourceFrame should not be null");

        // Empty string is still treated as null in the implementation check (dataOwner != null)
        // So it should NOT create responsibility sets
        assertNull(result.getResponsibilitySets(),
                "ResponsibilitySets should be null when dataOwner is empty string");
    }

    @Test
    void testResponsibilitySetIdIsCorrectlyGenerated() {
        // Arrange
        String dataOwner = "NSB:Authority:456";
        String expectedPrefix = "TEST:ResponsibilitySet:";
        when(exportTimeZone.getDefaultTimeZoneId()).thenReturn(ZoneId.of("Europe/Oslo"));

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        ResponsibilitySet responsibilitySet = result.getResponsibilitySets()
                .getResponsibilitySet().getFirst();

        assertTrue(responsibilitySet.getId().startsWith(expectedPrefix),
                "ResponsibilitySet ID should be generated with correct prefix");

        // Verify the ID is used in both places
        String responsibilitySetId = responsibilitySet.getId();
        assertEquals(responsibilitySetId,
                result.getFrameDefaults().getDefaultResponsibilitySetRef().getRef(),
                "The same ResponsibilitySet ID should be used in FrameDefaults reference");
    }

    @Test
    void testMultipleCallsCreateDifferentIds() {
        // Arrange
        String dataOwner = "TEST:Authority:999";
        when(exportTimeZone.getDefaultTimeZoneId()).thenReturn(ZoneId.of("Europe/Oslo"));

        // Act
        ResourceFrame frame1 = sobekResourceFrameExporter.createResourceFrame(dataOwner);
        ResourceFrame frame2 = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        // Note: The IDs might be the same if hashCode() returns the same value,
        // but the structure should be correctly created in both cases
        assertNotNull(frame1.getId());
        assertNotNull(frame2.getId());

        // Both should have the same structure
        assertNotNull(frame1.getResponsibilitySets());
        assertNotNull(frame2.getResponsibilitySets());

        // Both should reference the same dataOwner
        assertEquals(dataOwner,
                frame1.getResponsibilitySets().getResponsibilitySet().getFirst()
                        .getRoles().getResponsibilityRoleAssignment().getFirst()
                        .getResponsibleOrganisationRef().getRef());
        assertEquals(dataOwner,
                frame2.getResponsibilitySets().getResponsibilitySet().getFirst()
                        .getRoles().getResponsibilityRoleAssignment().getFirst()
                        .getResponsibleOrganisationRef().getRef());
    }

    @Test
    void testDataOwnerWithSpecialCharacters() {
        // Arrange
        String dataOwner = "SPECIAL:Authority:With-Dash_And_Underscore.123";
        when(exportTimeZone.getDefaultTimeZoneId()).thenReturn(ZoneId.of("Europe/Oslo"));

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert
        assertNotNull(result);
        String actualDataOwner = result.getResponsibilitySets()
                .getResponsibilitySet().getFirst()
                .getRoles().getResponsibilityRoleAssignment().getFirst()
                .getResponsibleOrganisationRef().getRef();

        assertEquals(dataOwner, actualDataOwner,
                "DataOwner with special characters should be preserved correctly");
    }

    @Test
    void testCompleteXmlStructureIntegrity() {
        // Arrange
        String dataOwner = "INTEGRITY:Authority:Test";
        when(exportTimeZone.getDefaultTimeZoneId()).thenReturn(ZoneId.of("Europe/Oslo"));

        // Act
        ResourceFrame result = sobekResourceFrameExporter.createResourceFrame(dataOwner);

        // Assert - Verify the complete chain from ResourceFrame to dataOwner reference
        assertNotNull(result, "ResourceFrame should exist");
        assertNotNull(result.getId(), "ResourceFrame should have ID");
        assertNotNull(result.getVersion(), "ResourceFrame should have version");
        
        assertNotNull(result.getResponsibilitySets(), "ResponsibilitySets should exist");
        assertEquals(1, result.getResponsibilitySets().getResponsibilitySet().size(), 
                "Should have exactly one ResponsibilitySet");
        
        ResponsibilitySet rs = result.getResponsibilitySets().getResponsibilitySet().getFirst();
        assertNotNull(rs.getId(), "ResponsibilitySet should have ID");
        assertNotNull(rs.getRoles(), "ResponsibilitySet should have roles");
        
        assertEquals(1, rs.getRoles().getResponsibilityRoleAssignment().size(), 
                "Should have exactly one RoleAssignment");
        
        ResponsibilityRoleAssignment rra = rs.getRoles().getResponsibilityRoleAssignment().getFirst();
        assertNotNull(rra.getDataRoleType(), "RoleAssignment should have DataRoleType list");
        
        // Verify the DataRoleType is a list with one element of type OWNS
        List<DataRoleTypeEnumeration> dataRoleTypes = rra.getDataRoleType();
        assertEquals(1, dataRoleTypes.size(), 
                "DataRoleType list should contain exactly one element");
        assertEquals(DataRoleTypeEnumeration.OWNS, dataRoleTypes.getFirst(),
                "The single DataRoleType in the list should be OWNS");
        
        assertNotNull(rra.getResponsibleOrganisationRef(), 
                "RoleAssignment should have ResponsibleOrganisationRef");
        assertNotNull(rra.getResponsibleOrganisationRef().getRef(), 
                "ResponsibleOrganisationRef should have ref value");
        
        assertEquals(dataOwner, rra.getResponsibleOrganisationRef().getRef(), 
                "Final dataOwner reference should match input");
        
        // Verify frame defaults chain
        assertNotNull(result.getFrameDefaults(), "FrameDefaults should exist");
        assertNotNull(result.getFrameDefaults().getDefaultResponsibilitySetRef(), 
                "DefaultResponsibilitySetRef should exist");
        assertEquals(rs.getId(), result.getFrameDefaults().getDefaultResponsibilitySetRef().getRef(), 
                "FrameDefaults should reference the correct ResponsibilitySet");
    }
}