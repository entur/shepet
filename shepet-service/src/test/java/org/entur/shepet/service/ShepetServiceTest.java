package org.entur.shepet.service;

import static org.junit.jupiter.api.Assertions.*;

import org.entur.shepet.SpringConfig;
import org.entur.shepet.model.GetKjoretoyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { SpringConfig.class })
class ShepetServiceTest {

  @Autowired
  ShepetService service;

  @Test
  void getVehiclePersonalVehicle() {
    GetKjoretoyResponse result = service.getVehicle("EV25288");
    assertEquals(
      "EV 25288",
      result
        .getKjoretoydataListe()
        .getFirst()
        .getKjennemerke()
        .getFirst()
        .getKjennemerke()
    );
  }

  @Test
  void getVehicleBus() {
    GetKjoretoyResponse result = service.getVehicle("VJ14926");
    assertEquals(
      "VJ 14926",
      result
        .getKjoretoydataListe()
        .getFirst()
        .getKjennemerke()
        .getFirst()
        .getKjennemerke()
    );
  }
}
