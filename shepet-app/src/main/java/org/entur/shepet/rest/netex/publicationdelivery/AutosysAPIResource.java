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

package org.entur.shepet.rest.netex.publicationdelivery;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.xml.bind.JAXBException;
import org.entur.shepet.model.Kjoretoydata;
import org.entur.shepet.model.dto.BulkResultDto;
import org.entur.shepet.model.dto.FetchVehicleErrorDto;
import org.entur.shepet.model.dto.VehicleBulkInputDto;
import org.entur.shepet.service.VehicleBulkService;
import org.entur.shepet.mapping.MapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

@Component
@Tag(name = "Sync export resource", description = "Sync export resource")
@Produces("application/xml")
@Path("autosys")
public class AutosysAPIResource {

    private static final Logger logger = LoggerFactory.getLogger(AutosysAPIResource.class);

    private final VehicleBulkService vehicleBulkService;
    private final MapperService mapperService;
    private final PublicationDeliveryStreamingOutput publicationDeliveryStreamingOutput;

    @Autowired
    public AutosysAPIResource(PublicationDeliveryStreamingOutput publicationDeliveryStreamingOutput,
                              VehicleBulkService vehicleBulkService,
                              MapperService mapperService) {
        this.vehicleBulkService = vehicleBulkService;
        this.mapperService = mapperService;
        this.publicationDeliveryStreamingOutput = publicationDeliveryStreamingOutput;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML + "; charset=UTF-8")
    public Response getVehicleFromAutosys(@QueryParam("registrationNumber")String registrationNumber,
                                          @QueryParam("dataOwner") String dataOwner) throws JAXBException, IOException, SAXException {

        return getVehiclesFromAutosys(List.of(new VehicleBulkInputDto(registrationNumber, null)), dataOwner);
    }

    @POST
    @Path("vehicles")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML + "; charset=UTF-8")
    public Response getVehiclesFromAutosys(
            List<VehicleBulkInputDto> vehicleBulkInputDtos,
            @QueryParam("dataOwner") String dataOwner) throws JAXBException, IOException, SAXException {

        logger.info("Received request for {} vehicles with dataOwner: {}",
                vehicleBulkInputDtos != null ? vehicleBulkInputDtos.size() : 0, dataOwner);

        if (vehicleBulkInputDtos == null || vehicleBulkInputDtos.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Vehicle import list cannot be empty")
                    .build();
        }

        if (vehicleBulkInputDtos.stream().anyMatch(input -> input == null
                || input.getRegistrationNumber() == null
                || input.getRegistrationNumber().isBlank())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Each vehicle must have a non-blank registrationNumber")
                    .build();
        }

        BulkResultDto fetchResults =
                vehicleBulkService.fetchAndDeduplicateVehicles(vehicleBulkInputDtos);

        List<Kjoretoydata> uniqueVehicleData = fetchResults.uniqueVehicles();
        List<FetchVehicleErrorDto> fetchErrors = fetchResults.fetchErrors();

        var netexData = mapperService.exportPublicationDeliveryWithAutosysVehicle(
                uniqueVehicleData, fetchErrors, dataOwner, vehicleBulkInputDtos);

        return Response.ok(publicationDeliveryStreamingOutput.stream(netexData)).build();
    }
}
