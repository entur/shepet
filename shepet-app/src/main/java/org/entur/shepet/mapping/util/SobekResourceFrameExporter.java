/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.entur.shepet.mapping.util;

import org.entur.netex2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class SobekResourceFrameExporter {

    private final NetexIdHelper netexIdHelper;
    private final String defaultLanguage;
    private final ExportTimeZone exportTimeZone;

    @Autowired
    public SobekResourceFrameExporter(NetexIdHelper netexIdHelper,
                                      @Value("${sobek.locals.language.default:nor}") String defaultLanguage,
                                      ExportTimeZone exportTimeZone) {

        this.netexIdHelper = netexIdHelper;
        this.defaultLanguage = defaultLanguage;
        this.exportTimeZone = exportTimeZone;
    }


    public ResourceFrame createResourceFrame(String dataOwner){
        ResourceFrame resourceFrame = new ResourceFrame();
        resourceFrame.setVersion("1");
        resourceFrame.setId(netexIdHelper.getNetexId("ResourceFrame",resourceFrame.hashCode()));

        String responsibilitySetId = null;

        if(dataOwner != null && !dataOwner.isEmpty()) {
            responsibilitySetId = netexIdHelper.getNetexId("ResponsibilitySet", resourceFrame.hashCode());
            resourceFrame.withResponsibilitySets(
                    new ResponsibilitySetsInFrame_RelStructure().withResponsibilitySet(
                            new ResponsibilitySet().withId(responsibilitySetId)
                                    .withVersion("1")
                                    .withRoles(
                                            new ResponsibilityRoleAssignments_RelStructure().withResponsibilityRoleAssignment(
                                                    new ResponsibilityRoleAssignment().withDataRoleType(DataRoleTypeEnumeration.OWNS)
                                                            .withId(netexIdHelper.getNetexId("ResponsibilityRoleAssignment", resourceFrame.hashCode()))
                                                            .withVersion("1")
                                                            .withResponsibleOrganisationRef(new OrganisationRefStructure().withRef(dataOwner))
                                            )
                                    )));
        }

        VersionFrameDefaultsStructure frameDefaults =
                new VersionFrameDefaultsStructure()
                        .withDefaultLocale(new LocaleStructure()
                                .withDefaultLanguage(defaultLanguage)
                                .withTimeZone(exportTimeZone.getDefaultTimeZoneId().toString()));

        if(responsibilitySetId != null) {
            frameDefaults.withDefaultResponsibilitySetRef(
                        new ResponsibilitySetRefStructure().withRef(responsibilitySetId));
        }

        resourceFrame.withFrameDefaults(frameDefaults);

        return resourceFrame;
    }
}
