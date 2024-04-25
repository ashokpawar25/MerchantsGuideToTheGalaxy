package com.amaap.merchentguide.domain.service.io.parser;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.model.dto.QueryParserDto;
import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.RomanNumbers;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.IntergalacticUnitService;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.amaap.merchentguide.domain.service.UnitConverter.romanToDecimalConverter;

public class InputParser {

    public static IntergalacticUnitDto parseUnit(String line) throws IOException {
        line = line.replaceAll("\\s+", " ");
        String[] lineData = line.split(" ");
        String interGalacticUnit = lineData[0];
        String romanValue = lineData[2].toUpperCase();
        int actualValue = RomanNumbers.valueOf(romanValue).getValue();
        return new IntergalacticUnitDto(interGalacticUnit,romanValue,actualValue);
    }

    public static MetalDto parseMetal(String line, IntergalacticUnitService intergalacticUnitService) throws IOException, InvalidRomanValueException {
        line = line.replaceAll("\\s+", " ");
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("src/main/java/com/amaap/merchentguide/resources/validData.yml");
        Map<String, List<String>> yamlData = yaml.load(inputStream);
        List<String> validMetals = yamlData.get("validMetals");
        inputStream.close();
        String [] lineData = line.split(" ");
        StringBuilder romanValue = new StringBuilder();
        String metal = null;
        for(String data:lineData)
        {
            if(validMetals.contains(data))
            {
                metal = data;
            }
        }
        for(int i = 0;i< lineData.length-4;i++)
        {
            IntergalacticUnit intergalacticUnit = intergalacticUnitService.get(lineData[i]);
            romanValue.append(intergalacticUnit.getRomanValue());
        }
        long totalUnits = romanToDecimalConverter(romanValue.toString());
        double totalCredits = Long.parseLong(lineData[lineData.length-2]);
        double creditsForSingleUnit = totalCredits/totalUnits;
        return new MetalDto(metal,creditsForSingleUnit);
    }

    public static QueryParserDto parseQuery(String line) {
        line = line.replaceAll("\\s+", " ");
        QueryType queryType;
        if(line.matches("^how much is (.+)\\s*\\?$"))
        {
            queryType = QueryType.UNIT_QUERY;
        }
        else if(line.matches("^how many Credits is (.+) ([A-Za-z]+)\\s*\\?$"))
        {
            queryType = QueryType.METAL_QUERY;
        }
        else
        {
            queryType = QueryType.INVALID_QUERY;
        }
        return new QueryParserDto(queryType,line);
    }
}
