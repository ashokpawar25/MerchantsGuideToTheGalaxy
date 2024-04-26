package com.amaap.merchentguide;

import com.amaap.merchentguide.controller.GalaxyController;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws InvalidInputFileDataException, InvalidRomanValueException {
        Injector injector = Guice.createInjector(new InMemoryModule());
        GalaxyController galaxyController = injector.getInstance(GalaxyController.class);
        galaxyController.readFile("src/main/java/com/amaap/merchentguide/resources/inputData.txt");
        String result = galaxyController.processQueries();
        System.out.println(result);
    }
}
