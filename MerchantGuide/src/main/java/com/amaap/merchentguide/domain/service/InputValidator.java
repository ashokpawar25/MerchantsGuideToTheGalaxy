package com.amaap.merchentguide.domain.service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InputValidator {
    public static boolean unitValidator(String line) throws IOException {
        Yaml yaml = new Yaml();
        FileInputStream inputStream = new FileInputStream("G:\\Amaap\\MerchentGuide\\MerchantGuide\\src\\main\\java\\com\\amaap\\merchentguide\\domain\\resources\\interGalacticUnit.yml");
        Map<String, List<String>> yamlData = yaml.load(inputStream);
        inputStream.close();
        List<String> validUnits = yamlData.get("interGalacticUnits");
        String [] lineData = line.split(" ");
        if(validUnits.contains(lineData[0]))
            return true;
        return false;
    }
}