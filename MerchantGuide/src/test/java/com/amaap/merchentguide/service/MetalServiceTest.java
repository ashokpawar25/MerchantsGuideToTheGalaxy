package com.amaap.merchentguide.service;

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

class MetalServiceTest {
    MetalService metalService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        metalService = injector.getInstance(MetalService.class);
    }

    @Test
    void shouldBeAbleToCreateMetal() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name, credits);

        // act
        Metal actual = metalService.create(name, credits);

        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToThrowExceptionWhenMetalIsAlreadyPresentInDatabase() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        metalService.create("Silver", 17);

        // assert
        assertThrows(MetalAlreadyExistException.class, () -> metalService.create("Silver", 17));

    }

    @Test
    void shouldBeAbleToGetMetalByName() throws InvalidMetalDataException, MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name, credits);

        // act
        metalService.create(name, credits);
        Metal actual = metalService.getMetal(name);

        // assert
        assertEquals(expected, actual);
    }

}