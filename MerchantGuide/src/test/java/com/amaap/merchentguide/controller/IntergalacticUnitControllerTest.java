package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.service.IntergalacticUnitService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntergalacticUnitControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    IntergalacticUnitRepository intergalacticUnitRepository = new InMemoryIntergalacticUnitRepository(inMemoryDatabase);
    IntergalacticUnitService intergalacticUnitService = new IntergalacticUnitService(intergalacticUnitRepository);

    IntergalacticUnitController intergalacticUnitController = new IntergalacticUnitController(intergalacticUnitService);
    @Test
    void shouldBeAbleToGetOkResponseWhenCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        Response expected = new Response(HttpStatus.OK,"Intergalactic unit created");

        // act
        Response actual = intergalacticUnitController.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenTryToCreateDuplicateIntergalacticUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        intergalacticUnitController.create("glob","I",1);
        Response expected = new Response(HttpStatus.CONFLICT,"glob unit is already present");

        // act
        Response actual = intergalacticUnitController.create("glob","V",5);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        intergalacticUnitController.create(intergalacticValue,romanValue,actualValue);
        IntergalacticUnit actual = intergalacticUnitController.get(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }
}
