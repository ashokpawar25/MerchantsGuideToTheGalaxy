package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.entity.ParsedUnitResponseDto;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InputParser {
    public static ParsedUnitResponseDto parseUnit(String line) throws IOException {

        String[] lineData = line.split(" ");
        String interGalacticUnit = lineData[0];
        String romanValue = lineData[2];

        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("G:\\Amaap\\MerchentGuide\\MerchantGuide\\src\\main\\java\\com\\amaap\\merchentguide\\domain\\resources\\RomanValues.yml");
        Map<String, Integer> yamlData = yaml.load(inputStream);
        inputStream.close();
        Integer actualValue = yamlData.get(romanValue);
        ParsedUnitResponseDto dto = new ParsedUnitResponseDto(interGalacticUnit,romanValue,actualValue);
        return dto;
    }
}
