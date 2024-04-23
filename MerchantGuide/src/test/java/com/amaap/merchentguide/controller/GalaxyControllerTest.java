package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.service.GalaxyService;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import com.amaap.merchentguide.service.MetalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GalaxyControllerTest {
    IntergalacticTransactionUnitService intergalacticTransactionUnitService =
            new IntergalacticTransactionUnitService(
                    new InMemoryIntergalacticTransactionUnitRepository(
                            new FakeInMemoryDatabase()));

    MetalService metalService = new MetalService(new InMemoryMetalRepository(new FakeInMemoryDatabase()));

    GalaxyService ioService = new GalaxyService(intergalacticTransactionUnitService,metalService);
    GalaxyController galaxyController = new GalaxyController(ioService);

    @Test
    void shouldBeAbleToReadAndProcessFileData()
    {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//inputData.txt";

        // act
        boolean isReadable = galaxyController.readFile(filePath);

        // assert
        assertTrue(isReadable);
    }
}
