package org.entur.shepet.model.dto;

import org.entur.shepet.model.Kjoretoydata;

import java.util.List;

public record BulkResultDto(List<Kjoretoydata> uniqueVehicles, List<FetchVehicleErrorDto> fetchErrors) {
}
