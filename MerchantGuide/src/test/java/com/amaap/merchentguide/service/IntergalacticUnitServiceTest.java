package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticUnitServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    IntergalacticUnitRepository intergalacticUnitRepository = new InMemoryIntergalacticUnitRepository(inMemoryDatabase);
    IntergalacticUnitService intergalacticUnitService = new IntergalacticUnitService(intergalacticUnitRepository);

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticUnit actual = intergalacticUnitService.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        intergalacticUnitService.create(intergalacticValue,romanValue,actualValue);
        IntergalacticUnit actual = intergalacticUnitService.get(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }
}