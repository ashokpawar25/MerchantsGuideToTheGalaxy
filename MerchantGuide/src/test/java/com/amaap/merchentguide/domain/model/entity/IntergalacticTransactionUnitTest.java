package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueExceptionTransactionUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticTransactionUnitTest {

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticTransactionUnit expected = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticTransactionUnit actual = IntergalacticTransactionUnit.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidDataIsProvided()
    {
        assertThrows(InvalidIntergalacticTransactionUnitValueException.class,()->IntergalacticTransactionUnit.create("","I",1));
        assertThrows(InvalidRomanValueExceptionTransactionUnit.class,()->IntergalacticTransactionUnit.create("glob",null,1));
    }

}