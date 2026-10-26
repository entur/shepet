package org.entur.shepet.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FetchVehicleErrorDto {
    private String message;
    private String registrationNumber;

    public FetchVehicleErrorDto(String message, String registrationNumber) {
        this.message = message;
        this.registrationNumber = registrationNumber;
    }
}
