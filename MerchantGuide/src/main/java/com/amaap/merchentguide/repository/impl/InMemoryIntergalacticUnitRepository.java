package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import jakarta.inject.Inject;

public class InMemoryIntergalacticUnitRepository implements IntergalacticUnitRepository {
    private final InMemoryDatabase inMemoryDatabase;
    @Inject
    public InMemoryIntergalacticUnitRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }


    @Override
    public IntergalacticUnit add(String intergalacticValue, String romanValue, double actualValue) throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        return inMemoryDatabase.InsertIntoIntergalacticUnitTable(intergalacticValue,romanValue,actualValue);
    }

    @Override
    public IntergalacticUnit find(String intergalacticValue) {
        return inMemoryDatabase.selectFromIntergalacticUnitTable(intergalacticValue);
    }
}
