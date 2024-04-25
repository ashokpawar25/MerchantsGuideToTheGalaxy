package com.amaap.merchentguide.domain.service.io.validator;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.amaap.merchentguide.domain.service.io.validator.InputValidator.metalCreditsValidator;
import static com.amaap.merchentguide.domain.service.io.validator.InputValidator.unitValidator;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @Test
    void shouldBeAbleToValidateIntergalacticUnitFromInputLine(){
        // arrange
        String inputLine = "glob is I";

        // act
        boolean isValid = unitValidator(inputLine);

        // assert
        assertTrue(isValid);
    }

    @Test
    void shouldBeAbleToValidateInvalidRomanValueFromInputLine() {
        // arrange
        String inputLine = "glob is S";

        // act
        boolean isValid = unitValidator(inputLine);

        // assert
        assertFalse(isValid);
    }

    @Test
    void shouldBeAbleToValidateValidMetalFromInputLine() throws IOException {
        // arrange
        String inputLine = "glob prok Gold is 57800 Credits";

        // act
        boolean isValid = metalCreditsValidator(inputLine);

        // assert
        assertTrue(isValid);
    }

    @Test
    void shouldBeAbleToValidateInvalidMetalFromInputLine() throws IOException {
        // arrange
        String inputLine = "glob prok wood is 57800 Credits";

        // act
        boolean isValid = metalCreditsValidator(inputLine);

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