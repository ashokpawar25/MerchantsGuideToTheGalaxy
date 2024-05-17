package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GalaxyControllerTest {
    GalaxyController galaxyController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        galaxyController = injector.getInstance(GalaxyController.class);
    }

    @Test
    void shouldBeAbleToReadAndProcessFileData() throws InvalidInputFileDataException {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";

        // act
        boolean isReadable = galaxyController.readFile(filePath);

        // assert
        assertTrue(isReadable);
    }

    @Test
    void shouldBeAbleToProcessQueryAndReturnResult() throws InvalidRomanValueException, InvalidInputFileDataException {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";
        String expected = "\npish tegj glob glob is 42\n" +
                "glob prok Silver is 68 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "glob prok Iron is 782 Credits\n" +
                "I have no idea what you are talking about";

        // act
        galaxyController.readFile(filePath);
        String actual = galaxyController.processQueries();

        // assert
        assertEquals(expected, actual);
    }
}
