package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.merchentguide.domain.model.valueobject.builder.QueryBuilder.getAllQueries;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GalaxyServiceTest {

    IntergalacticUnitService intergalacticUnitService =
            new IntergalacticUnitService(
                    new InMemoryIntergalacticUnitRepository(
                            new FakeInMemoryDatabase()));

    MetalService metalService = new MetalService(new InMemoryMetalRepository(new FakeInMemoryDatabase()));

    QueryService queryService = new QueryService(new InMemoryQueryRepository(new FakeInMemoryDatabase()));
    ProcessorFactory processorFactory = new ProcessorFactory(intergalacticUnitService,metalService);

    GalaxyService galaxyService = new GalaxyService(intergalacticUnitService,metalService,queryService, processorFactory);

    @Test
    void shouldBeAbleToReadFileAndInsertIntergalacticUnitIntoDatabase() {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";
        String expectedUnit = "I";

        // act
        boolean isReadable = galaxyService.readFile(filePath);
        IntergalacticUnit unit = intergalacticUnitService.get("glob");
        String actualUnit = unit.getRomanValue();

        // assert
        assertTrue(isReadable);
        assertEquals(expectedUnit,actualUnit);

    }

    @Test
    void shouldBeAbleToReadFileAndInsertMetalIntoDatabase() {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";
        String expectedMetal = "Silver";
        long expectedCredits = 17;


        // act
        boolean isReadable = galaxyService.readFile(filePath);
        Metal metal = metalService.getMetal("Silver");
        String actualMetal = metal.getName();
        double actualCredits = metal.getCredits();

        // assert
        assertTrue(isReadable);
        assertEquals(expectedMetal,actualMetal);
        assertEquals(expectedCredits,actualCredits);
    }

    @Test
    void shouldBeAbleToReadFileAndInsertQueryIntoDatabase() {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/inputData.txt";
        List<QueryDto> expected = getAllQueries();

        // act
        boolean isReadable = galaxyService.readFile(filePath);
        List<QueryDto> actual = queryService.getAllQueries();

        // assert
        assertTrue(isReadable);
        assertEquals(expected,actual);
    }
}