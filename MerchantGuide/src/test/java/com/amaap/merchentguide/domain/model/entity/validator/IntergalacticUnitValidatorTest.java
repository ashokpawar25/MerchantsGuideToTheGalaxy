package com.amaap.merchentguide.domain.model.entity.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticTransactionUnitValidator.isInvalidIntergalacticValue;
import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticTransactionUnitValidator.isInvalidRomanValue;
import static org.junit.jupiter.api.Assertions.*;

class IntergalacticUnitValidatorTest {

    @Test
    void shouldBeAbleToValidateValidIntergalacticUnit()
    {
        assertFalse(isInvalidIntergalacticValue("blog"));
        assertFalse(isInvalidIntergalacticValue("prok"));
    }

    @Test
    void shouldBeAbleToValidateInvalidIntergalacticUnit()
    {
        assertTrue(isInvalidIntergalacticValue(""));
        assertTrue(isInvalidIntergalacticValue(null));
        assertTrue(isInvalidIntergalacticValue("blog "));
        assertTrue(isInvalidIntergalacticValue("blog prok"));
        assertTrue(isInvalidIntergalacticValue("blog@"));
        assertTrue(isInvalidIntergalacticValue("    blog"));
        assertTrue(isInvalidIntergalacticValue("blog   "));
        assertTrue(isInvalidIntergalacticValue(" blog"));
    }

    @Test
    void shouldBeAbleToValidateValidRomanValue()
    {
        assertFalse(isInvalidRomanValue("I"));
        assertFalse(isInvalidRomanValue("V"));
        assertFalse(isInvalidRomanValue("X"));
        assertFalse(isInvalidRomanValue("L"));
        assertFalse(isInvalidRomanValue("C"));
        assertFalse(isInvalidRomanValue("D"));
        assertFalse(isInvalidRomanValue("M"));
    }

    @Test
    void shouldBeAbleToValidateInvalidRomanValue()
    {
        assertTrue(isInvalidRomanValue("i"));
        assertTrue(isInvalidRomanValue("c"));
        assertTrue(isInvalidRomanValue("i"));
        assertTrue(isInvalidRomanValue("ic"));
        assertTrue(isInvalidRomanValue("IC"));
        assertTrue(isInvalidRomanValue("@I"));
        assertTrue(isInvalidRomanValue("I "));
        assertTrue(isInvalidRomanValue(" I"));
        assertTrue(isInvalidRomanValue("    I"));
        assertTrue(isInvalidRomanValue("I   "));
        assertTrue(isInvalidRomanValue("I C"));
        assertTrue(isInvalidRomanValue(""));
        assertTrue(isInvalidRomanValue(null));

    }
}