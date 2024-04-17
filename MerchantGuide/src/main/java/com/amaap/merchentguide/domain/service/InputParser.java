package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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

    public static MetalDto parseMetal(String line, IntergalacticTransactionUnitService intergalacticUnitService) throws IOException, InvalidRomanValueException {
        Yaml yaml = new Yaml();
        FileInputStream intergalacticUnitInputStream = new FileInputStream("G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//interGalacticUnit.yml");
        FileInputStream metalInputStream = new FileInputStream("G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//validMetals.yml");
        Map<String, List<String>> yamlDataForUnits = yaml.load(intergalacticUnitInputStream);
        Map<String, List<String>> yamlDataForMetals = yaml.load(metalInputStream);
        List<String> validUnits = yamlDataForUnits.get("interGalacticUnits");
        List<String> validMetals = yamlDataForMetals.get("validMetals");
        intergalacticUnitInputStream.close();
        metalInputStream.close();
        String [] lineData = line.split(" ");
        StringBuilder romanValue = new StringBuilder();
        String metal = null;
        for(String data:lineData)
        {
            if(validUnits.contains(data)) {
                IntergalacticTransactionUnit intergalacticUnit = intergalacticUnitService.get(data);
                String romanValueForUnit = intergalacticUnit.getRomanValue();
                romanValue.append(romanValueForUnit);
            }
            else if(validMetals.contains(data))
            {
                metal = data;
            }
        }
        long totalUnits = UnitConverter.romanToDecimalConverter(romanValue.toString());
        long totalCredits = Long.parseLong(lineData[lineData.length-2]);
        long creditsForSingleUnit = totalCredits/totalUnits;
        MetalDto metalDto = new MetalDto(metal,creditsForSingleUnit);
        return metalDto;
    }
}
