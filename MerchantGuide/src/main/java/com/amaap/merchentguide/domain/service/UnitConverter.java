package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.valueobject.RomanNumbers;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;

public class UnitConverter {
    public static long romanToDecimalConverter(String romanValue) throws InvalidRomanValueException {

        if (romanValue == null || romanValue.isEmpty() || !romanValue.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
            throw new InvalidRomanValueException("Invalid roman value " + romanValue);

        long decimal = 0;
        long prevValue = 0;

        for (int i = romanValue.length() - 1; i >= 0; i--) {
            int currentValue = RomanNumbers.valueOf(String.valueOf(romanValue.charAt(i))).getValue();

            if (currentValue < prevValue) {
                decimal -= currentValue;
            } else {
                decimal += currentValue;
            }

            prevValue = currentValue;
        }

        return decimal;
    }
}
