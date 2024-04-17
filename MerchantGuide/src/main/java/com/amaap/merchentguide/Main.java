package com.amaap.merchentguide;

import com.amaap.merchentguide.domain.service.UnitConverter;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;

public class Main {
    public static void main(String[] args) throws InvalidRomanValueException {
        System.out.println(UnitConverter.romanToDecimalConverter("XI"));
    }
}