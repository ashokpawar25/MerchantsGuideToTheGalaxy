package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public interface IntergalacticTransactionUnitRepository {
    IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException;

    IntergalacticTransactionUnit find(String intergalacticValue);
}
