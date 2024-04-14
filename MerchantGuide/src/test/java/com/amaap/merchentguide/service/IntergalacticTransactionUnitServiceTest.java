package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticTransactionUnitRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticTransactionUnitServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository = new InMemoryIntergalacticTransactionUnitRepository(inMemoryDatabase);
    IntergalacticTransactionUnitService intergalacticTransactionUnitService = new IntergalacticTransactionUnitService(intergalacticTransactionUnitRepository);

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = intergalacticTransactionUnitService.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        intergalacticTransactionUnitService.create(intergalacticValue,romanValue,actualValue);
        IntergalacticTransactionUnit actual = intergalacticTransactionUnitService.get(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }
}