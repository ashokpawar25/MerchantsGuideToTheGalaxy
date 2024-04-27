package com.amaap.merchentguide.domain.service.validator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void shouldBeAbleToValidateIntergalacticUnitFromInputLine(){
        // arrange
        String inputLine = "glob is I";

        // act
        boolean isValid = InputValidator.unitValidator(inputLine);

        // assert
        assertTrue(isValid);
    }

    @Test
    void shouldBeAbleToValidateInvalidRomanValueFromInputLine() {
        // arrange
        String inputLine = "glob is S";

        // act
        boolean isValid = InputValidator.unitValidator(inputLine);

        // assert
        assertFalse(isValid);
    }

    @Test
    void shouldBeAbleToValidateValidMetalFromInputLine() throws IOException {
        // arrange
        String inputLine = "glob prok Gold is 57800 Credits";

        // act
        boolean isValid = InputValidator.metalCreditsValidator(inputLine);

        // assert
        assertTrue(isValid);
    }

    @Test
    void shouldBeAbleToValidateInvalidMetalFromInputLine() throws IOException {
        // arrange
        String inputLine = "glob prok wood is 57800 Credits";

        // act
        boolean isValid = InputValidator.metalCreditsValidator(inputLine);

        // assert
        assertFalse(isValid);
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange & act
        InputValidator inputValidator = new InputValidator();

        // assert
        assertNotNull(inputValidator);
    }
}