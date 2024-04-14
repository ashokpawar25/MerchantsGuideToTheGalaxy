package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticDataException;

public interface IntergalacticTransactionUnitRepository {
    IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticDataException;
}
