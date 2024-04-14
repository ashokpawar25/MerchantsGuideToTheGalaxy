package com.amaap.merchentguide.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.merchentguide.domain.model.entity.validator.MetalValidator.isInvalidMetalName;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MetalValidatorTest {

    @Test
    void shouldBeAbleToValidateValidMetalName()
    {
        assertFalse(isInvalidMetalName("Silver"));
        assertFalse(isInvalidMetalName("Gold"));
        assertFalse(isInvalidMetalName("Iron"));
    }

    @Test
    void shouldBeAbleToValidateInValidMetalName()
    {
        assertTrue(isInvalidMetalName(""));
        assertTrue(isInvalidMetalName(null));
        assertTrue(isInvalidMetalName(" S"));
        assertTrue(isInvalidMetalName("S "));
        assertTrue(isInvalidMetalName("Silver "));
        assertTrue(isInvalidMetalName(" Silver"));
        assertTrue(isInvalidMetalName("Silver@"));
        assertTrue(isInvalidMetalName("Silver   "));
        assertTrue(isInvalidMetalName(" Silver"));
        assertTrue(isInvalidMetalName("Silver Gold"));

    }
}