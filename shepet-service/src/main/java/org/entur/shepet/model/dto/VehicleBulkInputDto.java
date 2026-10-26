package org.entur.shepet.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleBulkInputDto {
    private String registrationNumber;
    private String operationalNumber;

    public VehicleBulkInputDto() {
    }

    public VehicleBulkInputDto(String registrationNumber, String operationalNumber) {
        this.registrationNumber = registrationNumber;
        this.operationalNumber = operationalNumber;
    }
}
