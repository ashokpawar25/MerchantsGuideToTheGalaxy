package com.amaap.merchentguide.domain.service.validator;

import com.amaap.merchentguide.domain.model.valueobject.RomanNumbers;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InputValidator {
    public static boolean validateUnit(String line){
        line = line.replaceAll("\\s+", " ");
        String[] lineData = line.split(" ");
        String unit = lineData[2].toUpperCase();
        for (RomanNumbers romanNumber : RomanNumbers.values()) {
            if (romanNumber.name().equals(unit)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateMetalCredits(String line) throws IOException {
        line = line.replaceAll("\\s+", " ");
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("src/main/java/com/amaap/merchentguide/resources/validData.yml");
        Map<String, List<String>> yamlData = yaml.load(inputStream);
        inputStream.close();
        List<String> validMetals = yamlData.get("validMetals");
        String[] lineData = line.split(" ");
        if (validMetals.contains(lineData[lineData.length - 4])) return true;
        return false;
    }
}
