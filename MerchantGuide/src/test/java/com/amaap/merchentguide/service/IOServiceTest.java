package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IOServiceTest {

    IntergalacticTransactionUnitService intergalacticTransactionUnitService =
            new IntergalacticTransactionUnitService(
                    new InMemoryIntergalacticTransactionUnitRepository(
                            new FakeInMemoryDatabase()));
    IOService ioService = new IOService(intergalacticTransactionUnitService);

    @Test
    void shouldBeAbleToReadFileAndInsertUnitsIntoDatabase() {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//domain//resources//inputData.txt";
        String expected = "I";

        // act
        boolean isReadable = ioService.readFile(filePath);
        IntergalacticTransactionUnit unit = intergalacticTransactionUnitService.get("glob");
        String actual = unit.getRomanValue();

        // assert
        assertTrue(isReadable);
        assertEquals(expected,actual);
    }
}