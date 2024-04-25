package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryIntergalacticUnitRepositoryTest {

    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    IntergalacticUnitRepository intergalacticUnitRepository = new InMemoryIntergalacticUnitRepository(inMemoryDatabase);
    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticUnit actual = intergalacticUnitRepository.add(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        intergalacticUnitRepository.add(intergalacticValue,romanValue,actualValue);
        IntergalacticUnit actual = intergalacticUnitRepository.find(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }

}