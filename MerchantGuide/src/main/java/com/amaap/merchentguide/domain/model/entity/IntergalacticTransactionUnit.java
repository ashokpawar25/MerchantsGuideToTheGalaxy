package com.amaap.merchentguide.domain.model.entity;

import java.util.Objects;

public class IntergalacticTransactionUnit {
    private String intergalacticValue;
    private String romanValue;
    private int actualValue;
    public IntergalacticTransactionUnit(String intergalacticValue, String romanValue, int actualValue) {
        this.intergalacticValue = intergalacticValue;
        this.romanValue = romanValue;
        this.actualValue = actualValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntergalacticTransactionUnit that = (IntergalacticTransactionUnit) o;
        return actualValue == that.actualValue && Objects.equals(intergalacticValue, that.intergalacticValue) && Objects.equals(romanValue, that.romanValue);
    }

}
