package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidCreditsException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetalTest {

    @Test
    void shouldBeAbleToCreateMetal() throws InvalidMetalDataException {
        // arrange
        String name = "Gold";
        long credits = 1000;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = Metal.create(name,credits);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidDataIsPassed()
    {
        assertThrows(InvalidMetalNameException.class,()->Metal.create("",17));
        assertThrows(InvalidMetalNameException.class,()->Metal.create(null,17));
        assertThrows(InvalidCreditsException.class,()->Metal.create("Silver",0));
        assertThrows(InvalidCreditsException.class,()->Metal.create("Gold",-4));
    }
}