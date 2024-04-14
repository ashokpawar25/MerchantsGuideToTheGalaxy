package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;

public class IntergalacticTransactionUnitService {
    public IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) {
        return new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);
    }
}
