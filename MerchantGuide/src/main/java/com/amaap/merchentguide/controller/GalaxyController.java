package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.GalaxyService;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import jakarta.inject.Inject;

public class GalaxyController {
    GalaxyService galaxyService;
    @Inject
    public GalaxyController(GalaxyService galaxyService) {
        this.galaxyService = galaxyService;
    }

    public boolean readFile(String filePath) throws InvalidInputFileDataException {
        return galaxyService.readFile(filePath);
    }

    public String processQueries() throws InvalidRomanValueException {
        return galaxyService.processQueries();
    }
}
