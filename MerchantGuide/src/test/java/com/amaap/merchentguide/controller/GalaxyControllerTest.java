package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.*;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GalaxyControllerTest {
    IntergalacticUnitService intergalacticUnitService =
            new IntergalacticUnitService(
                    new InMemoryIntergalacticUnitRepository(
                            new FakeInMemoryDatabase()));

    MetalService metalService = new MetalService(new InMemoryMetalRepository(new FakeInMemoryDatabase()));
    QueryService queryService = new QueryService(new InMemoryQueryRepository(new FakeInMemoryDatabase()));
    ProcessorFactory processorFactory = new ProcessorFactory(intergalacticUnitService,metalService);
    GalaxyService galaxyService = new GalaxyService(intergalacticUnitService,metalService, queryService,processorFactory);
    GalaxyController galaxyController = new GalaxyController(galaxyService);

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
        assertEquals(expected,actual);
    }
}
