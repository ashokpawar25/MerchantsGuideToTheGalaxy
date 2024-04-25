package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public interface IntergalacticUnitRepository {
    IntergalacticUnit add(String intergalacticValue, String romanValue, double actualValue) throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException;

    IntergalacticUnit find(String intergalacticValue);
}
