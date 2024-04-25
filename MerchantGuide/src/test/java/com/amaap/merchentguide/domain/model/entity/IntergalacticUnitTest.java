package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueExceptionUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntergalacticUnitTest {

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException {
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
        assertThrows(InvalidIntergalacticUnitValueException.class,()-> IntergalacticUnit.create("","I",1));
        assertThrows(InvalidRomanValueExceptionUnit.class,()-> IntergalacticUnit.create("glob",null,1));
    }

    @Test
    void shouldBeAbleToCompareInstanceOfClass()
    {
        // arrange
        IntergalacticUnit intergalacticUnit1 = new IntergalacticUnit("glob","I",1);
        IntergalacticUnit intergalacticUnit2 = new IntergalacticUnit("glob","I",1);
        IntergalacticUnit intergalacticUnit3 = new IntergalacticUnit("prok","I",1);
        IntergalacticUnit intergalacticUnit4 = new IntergalacticUnit("glob","V",1);
        IntergalacticUnit intergalacticUnit5 = new IntergalacticUnit("glob","I",5);
        IntergalacticUnit intergalacticUnit6 = new IntergalacticUnit("prok","V",5);
        Object object = new Object();

        // act & assert
        assertTrue(intergalacticUnit1.equals(intergalacticUnit1));
        assertTrue(intergalacticUnit1.equals(intergalacticUnit2));
        assertFalse(intergalacticUnit1.equals(intergalacticUnit3));
        assertFalse(intergalacticUnit1.equals(intergalacticUnit4));
        assertFalse(intergalacticUnit1.equals(intergalacticUnit5));
        assertFalse(intergalacticUnit1.equals(intergalacticUnit6));
        assertFalse(intergalacticUnit1.equals(object));
        assertFalse(intergalacticUnit1.equals(null));
    }
}