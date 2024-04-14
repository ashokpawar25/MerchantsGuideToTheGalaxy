package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueException;
import com.amaap.merchentguide.domain.model.entity.validator.IntergalacticTransactionUnitValidator;

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

    public static IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticDataException {
        if(isInvalidIntergalacticValue(intergalacticValue)) throw new InvalidIntergalacticValueException("Invalid intergalactic value "+ intergalacticValue);
        if(isInvalidRomanValue(romanValue)) throw new InvalidRomanValueException("Invalid Roman value "+romanValue);
        return new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntergalacticTransactionUnit that = (IntergalacticTransactionUnit) o;
        return actualValue == that.actualValue && Objects.equals(intergalacticValue, that.intergalacticValue) && Objects.equals(romanValue, that.romanValue);
    }

}
