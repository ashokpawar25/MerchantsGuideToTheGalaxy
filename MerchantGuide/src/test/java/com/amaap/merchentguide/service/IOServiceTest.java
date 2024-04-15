package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IOServiceTest {

    IntergalacticTransactionUnitService intergalacticTransactionUnitService =
            new IntergalacticTransactionUnitService(
                    new InMemoryIntergalacticTransactionUnitRepository(
                            new FakeInMemoryDatabase()));

    MetalService metalService = new MetalService(new InMemoryMetalRepository(new FakeInMemoryDatabase()));

    IOService ioService = new IOService(intergalacticTransactionUnitService,metalService);

    @Test
    void shouldBeAbleToReadFileAndInsertUnitsIntoDatabase() {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//inputData.txt";
        String expectedUnit = "I";
        String expectedMetal = "Silver";

        // act
        boolean isReadable = ioService.readFile(filePath);
        IntergalacticTransactionUnit unit = intergalacticTransactionUnitService.get("glob");
        Metal metal = metalService.getMetal("Silver");
        String actualUnit = unit.getRomanValue();
        String actualMetal = metal.getName();

        // assert
        assertTrue(isReadable);
        assertEquals(expectedUnit,actualUnit);
        assertEquals(expectedMetal,actualMetal);
    }
}