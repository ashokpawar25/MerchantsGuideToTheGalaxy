package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntergalacticTransactionUnitControllerTest {

    IntergalacticTransactionUnitController intergalacticTransactionUnitController = new IntergalacticTransactionUnitController();
    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit()
    {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = intergalacticTransactionUnitController.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }
}
