package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueExceptionTransactionUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticUnitTest {

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticTransactionUnitDataException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue,romanValue,actualValue);

        // act
        IntergalacticUnit actual = IntergalacticUnit.create(intergalacticValue,romanValue,actualValue);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidDataIsProvided()
    {
        assertThrows(InvalidIntergalacticTransactionUnitValueException.class,()-> IntergalacticUnit.create("","I",1));
        assertThrows(InvalidRomanValueExceptionTransactionUnit.class,()-> IntergalacticUnit.create("glob",null,1));
    }

}