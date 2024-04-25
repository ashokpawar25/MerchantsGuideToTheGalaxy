package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.GalaxyService;

public class GalaxyController {
    GalaxyService galaxyService;
    public GalaxyController(GalaxyService galaxyService) {
        this.galaxyService = galaxyService;
    }

    public boolean readFile(String filePath) {
        return galaxyService.readFile(filePath);
    }

    public String processQueries() throws InvalidRomanValueException {
        return galaxyService.processQueries();
    }
}
