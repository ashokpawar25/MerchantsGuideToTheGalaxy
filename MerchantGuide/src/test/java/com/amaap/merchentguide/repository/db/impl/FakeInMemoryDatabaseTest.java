package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.service.MetalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeInMemoryDatabaseTest {
    FakeInMemoryDatabase fakeInMemoryDatabase = new FakeInMemoryDatabase();
    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = fakeInMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);

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
        fakeInMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);
        IntergalacticTransactionUnit actual = fakeInMemoryDatabase.selectFromIntergalacticTransactionUnitTable(intergalacticValue);

        // assert
        assertEquals(expected,actual);
    }


    @Test
    void shouldBeAbleToAddMetalIntoMetalTable() throws MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = fakeInMemoryDatabase.InsertIntoMetalTable(name,credits);

        // assert
        assertEquals(expected,actual);

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenMetalIsAlreadyPresentInDatabase() throws MetalAlreadyExistException {
        // arrange
        fakeInMemoryDatabase.InsertIntoMetalTable("Silver",17);

        // assert
        assertThrows(MetalAlreadyExistException.class,()-> fakeInMemoryDatabase.InsertIntoMetalTable("Silver",17));

    }

}