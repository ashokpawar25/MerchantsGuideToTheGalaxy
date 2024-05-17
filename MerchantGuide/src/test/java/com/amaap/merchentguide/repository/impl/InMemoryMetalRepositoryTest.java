package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InMemoryMetalRepositoryTest {
    InMemoryMetalRepository inMemoryMetalRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryMetalRepository = injector.getInstance(InMemoryMetalRepository.class);
    }

    @Test
    void shouldBeAbleToAddMetalIntoMetalTable() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name, credits);

        // act
        Metal actual = inMemoryMetalRepository.add(name, credits);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenMetalIsAlreadyPresentInDatabase() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        inMemoryMetalRepository.add("Silver", 17);

        // assert
        assertThrows(MetalAlreadyExistException.class, () -> inMemoryMetalRepository.add("Silver", 17));

    }

    @Test
    void shouldBeAbleToGetMetalByName() throws InvalidMetalDataException, MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name, credits);

        // act
        inMemoryMetalRepository.add(name, credits);
        Metal actual = inMemoryMetalRepository.selectFromMetalTable(name);

        // assert
        assertEquals(expected, actual);
    }

}