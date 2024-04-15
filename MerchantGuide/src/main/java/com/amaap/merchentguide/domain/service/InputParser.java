package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.model.entity.Metal;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class InputParser {
    public static IntergalacticUnitDto parseUnit(String line) throws IOException {

        String[] lineData = line.split(" ");
        String interGalacticUnit = lineData[0];
        String romanValue = lineData[2];

        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//RomanValues.yml");
        Map<String, Integer> yamlData = yaml.load(inputStream);
        inputStream.close();
        Integer actualValue = yamlData.get(romanValue);
        IntergalacticUnitDto dto = new IntergalacticUnitDto(interGalacticUnit,romanValue,actualValue);
        return dto;
    }

    public static MetalDto parseMetal(String line) {
        String [] lineData = line.split(" ");
        String metal = lineData[lineData.length-4];
        long credits = Long.parseLong(lineData[lineData.length-2]);
        MetalDto metalDto = new MetalDto(metal,credits);
        return metalDto;
    }
}
