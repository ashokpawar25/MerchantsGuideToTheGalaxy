package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.model.valueobject.HttpStatus;
import com.amaap.merchentguide.model.valueobject.Response;
import com.amaap.merchentguide.repository.IntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntergalacticTransactionUnitControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository = new InMemoryIntergalacticTransactionUnitRepository(inMemoryDatabase);
    IntergalacticTransactionUnitService intergalacticTransactionUnitService = new IntergalacticTransactionUnitService(intergalacticTransactionUnitRepository);

    IntergalacticTransactionUnitController intergalacticTransactionUnitController = new IntergalacticTransactionUnitController(intergalacticTransactionUnitService);
    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        Response expected = new Response(HttpStatus.OK,"Intergalactic unit created");

        // act
        Response actual = intergalacticTransactionUnitController.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        intergalacticTransactionUnitController.create(intergalacticValue,romanValue,actualValue);
        IntergalacticTransactionUnit actual = intergalacticTransactionUnitController.get(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }
}
