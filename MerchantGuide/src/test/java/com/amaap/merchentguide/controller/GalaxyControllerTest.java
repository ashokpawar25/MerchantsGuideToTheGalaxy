package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.GalaxyService;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import com.amaap.merchentguide.service.MetalService;
import com.amaap.merchentguide.service.QueryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GalaxyControllerTest {
    IntergalacticTransactionUnitService intergalacticTransactionUnitService =
            new IntergalacticTransactionUnitService(
                    new InMemoryIntergalacticTransactionUnitRepository(
                            new FakeInMemoryDatabase()));

    MetalService metalService = new MetalService(new InMemoryMetalRepository(new FakeInMemoryDatabase()));
    QueryService queryService = new QueryService(new InMemoryQueryRepository(new FakeInMemoryDatabase()));
    GalaxyService galaxyService = new GalaxyService(intergalacticTransactionUnitService,metalService, queryService);
    GalaxyController galaxyController = new GalaxyController(galaxyService);

    @Test
    void shouldBeAbleToReadAndProcessFileData()
    {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";

        // act
        boolean isReadable = galaxyController.readFile(filePath);

        // assert
        assertTrue(isReadable);
    }
}
