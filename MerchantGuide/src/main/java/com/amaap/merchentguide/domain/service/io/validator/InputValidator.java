package com.amaap.merchentguide.domain.service.io.validator;

import com.amaap.merchentguide.domain.model.valueobject.RomanNumbers;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class InputValidator {
    public static boolean unitValidator(String line) throws IOException {
        String[] lineData = line.split(" ");
        String unit = lineData[2].toUpperCase();
        for (RomanNumbers romanNumber : RomanNumbers.values()) {
            if (romanNumber.name().equals(unit)) {
                return true;
            }
        }
        return false;
    }

    public static boolean metalCreditsValidator(String line) throws IOException {
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
