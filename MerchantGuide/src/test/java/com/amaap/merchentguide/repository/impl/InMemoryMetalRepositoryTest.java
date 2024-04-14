package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.MetalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryMetalRepositoryTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    InMemoryMetalRepository inMemoryMetalRepository = new InMemoryMetalRepository(inMemoryDatabase);


    @Test
    void shouldBeAbleToAddMetalIntoMetalTable() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = inMemoryMetalRepository.add(name,credits);

        // assert
        assertEquals(expected,actual);

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenMetalIsAlreadyPresentInDatabase() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        inMemoryMetalRepository.add("Silver",17);

        // assert
        assertThrows(MetalAlreadyExistException.class,()-> inMemoryMetalRepository.add("Silver",17));

    }

    @Test
    void shouldBeAbleToGetMetalByName() throws InvalidMetalDataException, MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected  = new Metal(name,credits);

        // act
        inMemoryMetalRepository.add(name,credits);
        Metal actual = inMemoryMetalRepository.selectFromMetalTable(name);

        // assert
        assertEquals(expected,actual);
    }

}