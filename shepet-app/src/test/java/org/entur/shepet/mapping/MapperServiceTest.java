package org.entur.shepet.mapping;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileOutputStream;
import java.io.IOException;

import org.entur.shepet.ShepetTestApplication;
import org.entur.shepet.model.GetKjoretoyResponse;
import org.entur.shepet.rest.netex.publicationdelivery.PublicationDeliveryStreamingOutput;
import org.entur.shepet.service.ShepetService;
import org.junit.jupiter.api.Test;
import org.rutebanken.netex.model.PublicationDeliveryStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.xml.sax.SAXException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.xml.bind.JAXBException;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ShepetTestApplication.class)
@ActiveProfiles("test")
public class MapperServiceTest {

    @Autowired
    private ShepetService autosysVehicleService;
    @Autowired
    private MapperService mapperService;

    @Test
    public void TestPrivateVehicleMapping() throws WebApplicationException, IOException, JAXBException, SAXException {
        GetKjoretoyResponse autosysData = autosysVehicleService.getVehicle("EV25288");

        assertNotNull(autosysData);

        var netexData = mapperService.exportPublicationDeliveryWithAutosysVehicle(autosysData.getKjoretoydataListe());

        assertNotNull(netexData);

        write2File(netexData, "target/ev25288.xml");

    }

    @Test
    public void TestBusVehicleMapping() throws WebApplicationException, IOException, JAXBException, SAXException {
        GetKjoretoyResponse autosysData = autosysVehicleService.getVehicle("EH84771");

        assertNotNull(autosysData);

        var netexData = mapperService.exportPublicationDeliveryWithAutosysVehicle(autosysData.getKjoretoydataListe());

        assertNotNull(netexData);

        write2File(netexData, "target/eh84771.xml");

    }

    private void write2File(PublicationDeliveryStructure netexData, String filePath) throws WebApplicationException, IOException, JAXBException, SAXException {
        PublicationDeliveryStreamingOutput publicationDeliveryStreamingOutput = new PublicationDeliveryStreamingOutput();
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            var output = publicationDeliveryStreamingOutput.stream(netexData);
            output.write(fileOutputStream);
        }
    }
}
