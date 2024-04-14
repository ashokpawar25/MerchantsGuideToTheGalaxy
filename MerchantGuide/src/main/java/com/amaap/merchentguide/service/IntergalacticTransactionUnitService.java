package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.repository.IntergalacticTransactionUnitRepository;

public class IntergalacticTransactionUnitService {
    IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository;
    public IntergalacticTransactionUnitService(IntergalacticTransactionUnitRepository intergalacticTransactionUnitRepository) {
        this.intergalacticTransactionUnitRepository = intergalacticTransactionUnitRepository;
    }

    public IntergalacticTransactionUnit create(String intergalacticValue, String romanValue, int actualValue) {
        return intergalacticTransactionUnitRepository.add(intergalacticValue,romanValue,actualValue);
    }
}
