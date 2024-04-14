package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.repository.IntergalacticTransactionUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;

public class InMemoryIntergalacticTransactionUnitRepository implements IntergalacticTransactionUnitRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryIntergalacticTransactionUnitRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }


    @Override
    public IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue) {
        return inMemoryDatabase.InsertIntoIntergalacticTransactionUnitTable(intergalacticValue,romanValue,actualValue);
    }
}
