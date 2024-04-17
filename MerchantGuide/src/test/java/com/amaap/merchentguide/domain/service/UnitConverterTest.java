package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitConverterTest {
    @Test
    void shouldBeAbleToConvertRomanValueIntoDecimalValue() throws InvalidRomanValueException {
        // arrange
        String romanValue = "IV";
        long expected = 4;

        // act
        long actual = UnitConverter.romanToDecimalConverter(romanValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenRomanValueIsInvalid()
    {
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter(""));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter(null));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("IVF"));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("I V"));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("  XI"));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter(" X@"));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("Ci"));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("XM    "));
        assertThrows(InvalidRomanValueException.class,()-> UnitConverter.romanToDecimalConverter("abcd"));
    }
}