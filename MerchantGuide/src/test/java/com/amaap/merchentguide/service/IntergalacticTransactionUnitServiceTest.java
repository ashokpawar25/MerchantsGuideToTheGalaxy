package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticTransactionUnitServiceTest {
    IntergalacticTransactionUnitService intergalacticTransactionUnitService = new IntergalacticTransactionUnitService();

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit()
    {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = intergalacticTransactionUnitService.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

}