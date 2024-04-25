package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

public class InMemoryIntergalacticUnitRepository implements IntergalacticUnitRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryIntergalacticUnitRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }


    @Override
    public IntergalacticUnit add(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        return inMemoryDatabase.InsertIntoIntergalacticUnitTable(intergalacticValue,romanValue,actualValue);
    }

    @Override
    public IntergalacticUnit find(String intergalacticValue) {
        return inMemoryDatabase.selectFromIntergalacticUnitTable(intergalacticValue);
    }
}
