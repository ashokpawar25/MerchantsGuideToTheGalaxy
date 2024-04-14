package com.amaap.merchentguide.domain.model.entity;

public class ParsedUnitResponseDto {
    public String interGalacticValue;
    public String romanValue;
    public int actualValue;

    public ParsedUnitResponseDto(String interGalacticValue, String romanValue, int actualValue) {
        this.interGalacticValue = interGalacticValue;
        this.romanValue = romanValue;
        this.actualValue = actualValue;
    }
}
