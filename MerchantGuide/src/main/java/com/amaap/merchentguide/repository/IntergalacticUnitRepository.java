package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public interface IntergalacticUnitRepository {
    IntergalacticUnit add(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException;

    IntergalacticUnit find(String intergalacticValue);
}
