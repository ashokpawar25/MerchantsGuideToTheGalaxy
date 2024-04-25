package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import org.junit.jupiter.api.Test;

import static com.amaap.merchentguide.domain.service.UnitConverter.romanToDecimalConverter;
import static org.junit.jupiter.api.Assertions.*;

class UnitConverterTest {
    @Test
    void shouldBeAbleToConvertRomanValueIntoDecimalValue() throws InvalidRomanValueException {
        // arrange
        String romanValue = "IV";
        long expected = 4;

        // act
        long actual = romanToDecimalConverter(romanValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRomanValueIsInvalid()
    {
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter(""));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter(null));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("IVF"));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("I V"));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("  XI"));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter(" X@"));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("Ci"));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("XM    "));
        assertThrows(InvalidRomanValueException.class,()-> romanToDecimalConverter("abcd"));
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange & act
        UnitConverter unitConverter = new UnitConverter();

        // assert
        assertNotNull(unitConverter);
    }
}