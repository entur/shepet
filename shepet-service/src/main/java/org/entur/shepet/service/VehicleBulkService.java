package org.entur.shepet.service;

import org.entur.shepet.model.GetKjoretoyResponse;
import org.entur.shepet.model.Kjoretoydata;
import org.entur.shepet.model.dto.BulkResultDto;
import org.entur.shepet.model.dto.FetchVehicleErrorCode;
import org.entur.shepet.model.dto.FetchVehicleErrorDto;
import org.entur.shepet.model.dto.VehicleBulkInputDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleBulkService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleBulkService.class);

    private final ShepetService shepetService;

    public VehicleBulkService(ShepetService shepetService) {
        this.shepetService = shepetService;
    }

    /**
     * Fetches vehicle data for all provided vehicle identifiers and returns a deduplicated list.
     *
     * @param vehicleInputs List of vehicle identifiers to fetch
     * @return Tuple containing deduplicated list of vehicle data and list of fetch errors
     */
    public BulkResultDto fetchAndDeduplicateVehicles(List<VehicleBulkInputDto> vehicleInputs) {

        // Deduplicate on the normalized plate BEFORE calling Autosys, keeping input order
        Set<String> registrationNumbers = vehicleInputs.stream()
                .map(VehicleBulkInputDto::getRegistrationNumber)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        logger.info("Fetching vehicle data for {} unique registration numbers ({} inputs)",
                registrationNumbers.size(), vehicleInputs.size());

        // Collect all vehicle data from Autosys
        List<Kjoretoydata> allVehicleData = new ArrayList<>();
        List<FetchVehicleErrorDto> fetchErrors = new ArrayList<>();

        for (String registrationNumber : registrationNumbers) {
            try {
                GetKjoretoyResponse autosysData = shepetService.getVehicle(registrationNumber);
                if (autosysData.getKjoretoydataListe() != null) {
                    allVehicleData.addAll(autosysData.getKjoretoydataListe());
                }
            } catch (Exception e) {
                FetchVehicleErrorCode code = toErrorCode(e);

                if (code == FetchVehicleErrorCode.NOT_FOUND) {
                    logger.info("Vehicle with registration number {} not found in Autosys",
                            registrationNumber);
                } else {
                    // Full detail (status + SVV response body) stays in the log only
                    logger.warn("Failed to retrieve vehicle with registration number: {} ({})",
                            registrationNumber, code, e);
                }

                fetchErrors.add(new FetchVehicleErrorDto(code.name(), registrationNumber));

                // Continue with other vehicles
            }
        }

        // Remove duplicates based on vehicle ID (kjennemerke)
        List<Kjoretoydata> uniqueVehicleData = deduplicateVehicles(allVehicleData);

        logger.info("Reduced {} vehicles to {} unique vehicles with {} errors",
                allVehicleData.size(), uniqueVehicleData.size(), fetchErrors.size());

        return new BulkResultDto(uniqueVehicleData, fetchErrors);
    }

    /**
     * Deduplicates a list of vehicles based on their registration number (kjennemerke).
     * Keeps the first occurrence when duplicates are found.
     *
     * @param vehicles List of vehicles to deduplicate
     * @return Deduplicated list of vehicles
     */
    private List<Kjoretoydata> deduplicateVehicles(List<Kjoretoydata> vehicles) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getKjoretoyId() != null &&
                        vehicle.getKjoretoyId().getKjennemerke() != null)
                .collect(Collectors.toMap(
                        vehicle -> vehicle.getKjoretoyId().getKjennemerke(),
                        vehicle -> vehicle,
                        (existing, replacement) -> existing // Keep first occurrence
                ))
                .values()
                .stream()
                .toList();
    }

    private static FetchVehicleErrorCode toErrorCode(Throwable e) {
        // ShepetService wraps the RestClient exception, so walk the cause chain
        for (Throwable t = e; t != null; t = t.getCause()) {
            if (t instanceof HttpClientErrorException.NotFound) {
                return FetchVehicleErrorCode.NOT_FOUND;
            }
        }
        return FetchVehicleErrorCode.UPSTREAM_ERROR;
    }
}