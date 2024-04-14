package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.service.IOService;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IOControllerTest {
    IntergalacticTransactionUnitService intergalacticTransactionUnitService =
            new IntergalacticTransactionUnitService(
                    new InMemoryIntergalacticTransactionUnitRepository(
                            new FakeInMemoryDatabase()));
    IOService ioService = new IOService(intergalacticTransactionUnitService);
    IOController ioController = new IOController(ioService);

    @Test
    void shouldBeAbleToReadAndProcessFileData()
    {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//domain//resources//inputData.txt";

        // act
        boolean isReadable =ioController.readFile(filePath);

        // assert
        assertTrue(isReadable);
    }
}
