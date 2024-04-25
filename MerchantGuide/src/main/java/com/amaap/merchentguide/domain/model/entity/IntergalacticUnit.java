package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitValueException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidRomanValueExceptionUnit;

import java.util.Objects;

import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticUnitValidator.isInvalidIntergalacticValue;
import static com.amaap.merchentguide.domain.model.entity.validator.IntergalacticUnitValidator.isInvalidRomanValue;

public class IntergalacticUnit {
    private final String intergalacticValue;
    private final String romanValue;
    private final double actualValue;
    public IntergalacticUnit(String intergalacticValue, String romanValue, double actualValue) {
        this.intergalacticValue = intergalacticValue;
        this.romanValue = romanValue;
        this.actualValue = actualValue;
    }

    public static IntergalacticUnit create(String intergalacticValue, String romanValue, double actualValue) throws InvalidIntergalacticUnitDataException {
        if(isInvalidIntergalacticValue(intergalacticValue)) throw new InvalidIntergalacticUnitValueException("Invalid intergalactic value "+ intergalacticValue);
        if(isInvalidRomanValue(romanValue)) throw new InvalidRomanValueExceptionUnit("Invalid Roman value "+romanValue);
        return new IntergalacticUnit(intergalacticValue,romanValue,actualValue);
    }

    public String getIntergalacticValue() {
        return intergalacticValue;
    }

    public String getRomanValue() {
        return romanValue;
    }

    public double getActualValue() {
        return actualValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntergalacticUnit that = (IntergalacticUnit) o;
        return actualValue == that.actualValue && Objects.equals(intergalacticValue, that.intergalacticValue) && Objects.equals(romanValue, that.romanValue);
    }

}
