package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueExceptionTransactionUnit;

import java.util.Objects;

import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticTransactionUnitValidator.isInvalidIntergalacticValue;
import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticTransactionUnitValidator.isInvalidRomanValue;

public class IntergalacticTransactionUnit {
    private String intergalacticValue;
    private String romanValue;
    private int actualValue;
    public IntergalacticTransactionUnit(String intergalacticValue, String romanValue, int actualValue) {
        this.intergalacticValue = intergalacticValue;
        this.romanValue = romanValue;
        this.actualValue = actualValue;
    }

    public static IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException {
        if(isInvalidIntergalacticValue(intergalacticValue)) throw new InvalidIntergalacticTransactionUnitValueException("Invalid intergalactic value "+ intergalacticValue);
        if(isInvalidRomanValue(romanValue)) throw new InvalidRomanValueExceptionTransactionUnit("Invalid Roman value "+romanValue);
        return new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);
    }

    public String getIntergalacticValue() {
        return intergalacticValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntergalacticTransactionUnit that = (IntergalacticTransactionUnit) o;
        return actualValue == that.actualValue && Objects.equals(intergalacticValue, that.intergalacticValue) && Objects.equals(romanValue, that.romanValue);
    }

}
