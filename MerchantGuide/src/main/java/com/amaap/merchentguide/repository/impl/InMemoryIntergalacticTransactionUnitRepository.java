package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;

public class InMemoryIntergalacticTransactionUnitRepository implements IntergalacticTransactionUnitRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryIntergalacticTransactionUnitRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }


    @Override
    public IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException {
        return inMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);
    }

    @Override
    public IntergalacticTransactionUnit find(String intergalacticValue) {
        return inMemoryDatabase.selectFromIntergalacticTransactionUnitTable(intergalacticValue);
    }
}
