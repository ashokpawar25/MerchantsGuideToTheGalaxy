package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
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
}