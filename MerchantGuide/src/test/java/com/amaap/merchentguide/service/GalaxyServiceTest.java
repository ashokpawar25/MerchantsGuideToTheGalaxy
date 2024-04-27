package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.service.ProcessorFactory;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.merchentguide.domain.model.valueobject.builder.QueryBuilder.getAllQueries;
import static org.junit.jupiter.api.Assertions.*;

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
    void shouldBeAbleToReadFileAndInsertIntergalacticUnitIntoDatabase() throws InvalidInputFileDataException {
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
    void shouldBeAbleToReadFileAndInsertMetalIntoDatabase() throws InvalidInputFileDataException {
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
    void shouldBeAbleToReadFileAndInsertQueryIntoDatabase() throws InvalidInputFileDataException {
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

    @Test
    void shouldBeAbleToThrowExceptionWhenFileConsistInvalidData()
    {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/InvalidData.txt";

        // act & assert
        assertThrows(InvalidInputFileDataException.class,()->galaxyService.readFile(filePath));
    }

    @Test
    void shouldBeAbleToReturnFalseWhenFileConsistDuplicateIntergalacticUnit() throws InvalidInputFileDataException {
        // arrange
        String filePath = "src/main/java/com/amaap/merchentguide/resources/duplicateUnitDataFile.txt";

        // act
        boolean isReadable = galaxyService.readFile(filePath);

        // assert
        assertFalse(isReadable);
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
        galaxyService.readFile(filePath);
        String actual = galaxyService.processQueries();

        // assert
        assertEquals(expected,actual);
    }

}