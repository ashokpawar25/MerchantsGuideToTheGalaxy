package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticDataException;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;

public class IntergalacticTransactionUnitController {

    IntergalacticTransactionUnitService intergalacticTransactionUnitService;

    public IntergalacticTransactionUnitController(IntergalacticTransactionUnitService intergalacticTransactionUnitService) {
        this.intergalacticTransactionUnitService = intergalacticTransactionUnitService;
    }


    public IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticDataException {
        return intergalacticTransactionUnitService.create(intergalacticValue,romanValue,actualValue);
    }
}

