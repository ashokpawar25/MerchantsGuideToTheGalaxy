package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public class IntergalacticUnitService {
    IntergalacticUnitRepository intergalacticUnitRepository;
    public IntergalacticUnitService(IntergalacticUnitRepository intergalacticUnitRepository) {
        this.intergalacticUnitRepository = intergalacticUnitRepository;
    }

    public IntergalacticUnit create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        return intergalacticUnitRepository.add(intergalacticValue,romanValue,actualValue);
    }

    public IntergalacticUnit get(String intergalacticValue) {
        return intergalacticUnitRepository.find(intergalacticValue);
    }
}
