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

    GalaxyService ioService = new GalaxyService(intergalacticTransactionUnitService,metalService);

    @Test
    void shouldBeAbleToReadFileAndInsertIntergalacticUnitIntoDatabase() {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//inputData.txt";
        String expectedUnit = "I";

        // act
        boolean isReadable = ioService.readFile(filePath);
        IntergalacticTransactionUnit unit = intergalacticTransactionUnitService.get("glob");
        String actualUnit = unit.getRomanValue();

        // assert
        assertTrue(isReadable);
        assertEquals(expectedUnit,actualUnit);

    }

    @Test
    void shouldBeAbleToReadFileAndInsertMetalIntoDatabase() {
        // arrange
        String filePath = "G://Amaap//MerchentGuide//MerchantGuide//src//main//java//com//amaap//merchentguide//resources//inputData.txt";
        String expectedMetal = "Silver";
        long expectedCredits = 17;


        // act
        boolean isReadable = ioService.readFile(filePath);
        Metal metal = metalService.getMetal("Silver");
        String actualMetal = metal.getName();
        long actualCredits = metal.getCredits();

        // assert
        assertTrue(isReadable);
        assertEquals(expectedMetal,actualMetal);
        assertEquals(expectedCredits,actualCredits);
    }
}