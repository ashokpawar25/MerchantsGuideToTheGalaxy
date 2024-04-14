package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<IntergalacticTransactionUnit> intergalacticTransactionUnits = new ArrayList<>();
    @Override
    public IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(String intergalacticValue, String romanValue, int actualValue) {
        IntergalacticTransactionUnit intergalacticTransactionUnit = new IntergalacticTransactionUnit(intergalacticValue,romanValue,actualValue);
        intergalacticTransactionUnits.add(intergalacticTransactionUnit);
        return intergalacticTransactionUnit;

    }
}
