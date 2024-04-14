package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;

public class IntergalacticTransactionUnitController {
    public IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) {
        return new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);
    }
}

