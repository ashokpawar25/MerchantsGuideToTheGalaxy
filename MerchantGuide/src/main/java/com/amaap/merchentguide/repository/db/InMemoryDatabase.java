package com.amaap.merchentguide.repository.db;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public interface InMemoryDatabase {
    IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException;

    IntergalacticTransactionUnit selectFromIntergalacticTransactionUnitTable(String intergalacticValue);
}
