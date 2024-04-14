package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<IntergalacticTransactionUnit> intergalacticTransactionUnits = new ArrayList<>();
    @Override
    public IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException {
        IntergalacticTransactionUnit intergalacticTransactionUnit = IntergalacticTransactionUnit.create(intergalacticValue,romanValue,actualValue);
        Optional<IntergalacticTransactionUnit> existance = intergalacticTransactionUnits.stream().filter(unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue)).findFirst();
        if(existance.isPresent()) throw new IntergalacticUnitAlreadyExistException(intergalacticValue+" unit is already present");
        intergalacticTransactionUnits.add(intergalacticTransactionUnit);
        return intergalacticTransactionUnit;

    }

    @Override
    public IntergalacticTransactionUnit selectFromIntergalacticTransactionUnitTable(String intergalacticValue) {
        return intergalacticTransactionUnits.stream().filter(unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue)).findFirst().orElse(null);
    }
}
