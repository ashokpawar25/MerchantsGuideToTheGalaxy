package com.amaap.merchentguide.domain.model.dto;

public class IntergalacticUnitDto {
    public String interGalacticValue;
    public String romanValue;
    public int actualValue;

    public IntergalacticUnitDto(String interGalacticValue, String romanValue, int actualValue) {
        this.interGalacticValue = interGalacticValue;
        this.romanValue = romanValue;
        this.actualValue = actualValue;
    }
}
