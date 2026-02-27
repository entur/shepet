package org.entur.shepet.service;

import org.entur.shepet.model.GetKjoretoyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ShepetService {

  private final RestClient restClient;
  private final String apiKey;

  public ShepetService(
    @Value(
      "${autosys.api.base-url:https://akfell-datautlevering.atlas.vegvesen.no}"
    ) String baseUrl,
    @Value("${autosys.api.api-key}") String apiKey
  ) {
    this.restClient = RestClient.builder().baseUrl(baseUrl).build();
    this.apiKey = apiKey;
  }

  public GetKjoretoyResponse getVehicle(String registrationNumber) {
    try {
      // Example GET request
      GetKjoretoyResponse vehicle = restClient
        .get()
        .uri(
          "/enkeltoppslag/kjoretoydata?kjennemerke={registrationNumber}",
          registrationNumber
        )
        .header("SVV-Authorization", "Apikey " + apiKey)
        .retrieve()
        .body(GetKjoretoyResponse.class);

      return vehicle;
    } catch (Exception e) {
      // Handle exceptions appropriately
      throw new RuntimeException(
        "Failed to fetch vehicle: " + e.getMessage(),
        e
      );
    }
  }
}
