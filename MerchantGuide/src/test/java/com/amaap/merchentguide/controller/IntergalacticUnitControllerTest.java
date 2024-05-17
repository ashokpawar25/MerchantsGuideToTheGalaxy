package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntergalacticUnitControllerTest {
    IntergalacticUnitController intergalacticUnitController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        intergalacticUnitController = injector.getInstance(IntergalacticUnitController.class);
    }

    @Test
    void shouldBeAbleToGetOkResponseWhenCreateIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        Response expected = new Response(HttpStatus.OK, "Intergalactic unit created");

        // act
        Response actual = intergalacticUnitController.create(intergalacticValue, romanValue, actualValue);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetBadRequestAsResponseWhenInvalidDataIsPassed() throws InvalidIntergalacticUnitDataException {
        // arrange
        Response expected = new Response(HttpStatus.BADREQUEST, "Invalid Roman value S");

        // act
        Response actual = intergalacticUnitController.create("glob", "S", 5);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetConflictResponseWhenTryToCreateDuplicateIntergalacticUnit() throws InvalidIntergalacticUnitDataException {
        // arrange
        Response expected = new Response(HttpStatus.CONFLICT, "glob unit is already present");

        // act
        intergalacticUnitController.create("glob", "I", 1);
        Response actual = intergalacticUnitController.create("glob", "V", 5);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue, romanValue, actualValue);

        // act
        intergalacticUnitController.create(intergalacticValue, romanValue, actualValue);
        IntergalacticUnit actual = intergalacticUnitController.get(intergalacticValue);

        // assert
        assertEquals(expected, actual);
    }
}
