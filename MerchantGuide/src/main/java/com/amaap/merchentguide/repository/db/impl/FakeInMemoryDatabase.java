package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<IntergalacticTransactionUnit> intergalacticTransactionUnits = new ArrayList<>();
    List<Metal> metals = new ArrayList<>();
    List<QueryDto> queries = new ArrayList<>();

    @Override
    public IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(
            String intergalacticValue, String romanValue, int actualValue)
            throws InvalidIntergalacticTransactionUnitDataException,
            IntergalacticUnitAlreadyExistException {

        IntergalacticTransactionUnit intergalacticTransactionUnit = IntergalacticTransactionUnit.create(intergalacticValue,romanValue,actualValue);
        Optional<IntergalacticTransactionUnit> existence = intergalacticTransactionUnits.stream().filter(unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue)).findFirst();
        if(existence.isPresent()) throw new IntergalacticUnitAlreadyExistException(intergalacticValue+" unit is already present");
        intergalacticTransactionUnits.add(intergalacticTransactionUnit);
        return intergalacticTransactionUnit;

    }

    @Override
    public IntergalacticTransactionUnit selectFromIntergalacticTransactionUnitTable(
            String intergalacticValue) {
        return intergalacticTransactionUnits.stream().filter
                (unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue))
                .findFirst().orElse(null);
    }

    @Override
    public Metal InsertIntoMetalTable(String name, long credits)
            throws MetalAlreadyExistException, InvalidMetalDataException {
        Optional<Metal> existence = metals.stream().filter
                (metal -> metal.getName().equalsIgnoreCase(name)).findFirst();
        if(existence.isPresent()) throw new MetalAlreadyExistException(name +" is already present");
        Metal metalToAdd = Metal.create(name,credits);
        metals.add(metalToAdd);
     return metalToAdd;
    }

    public Metal selectFromMetalTable(String name) {
        return metals.stream().filter(metal -> metal.getName().equalsIgnoreCase(name)).findFirst().orElseThrow();
    }

    @Override
    public QueryDto insertIntoQueryTable(QueryDto queryDto) {
        queries.add(queryDto);
        return queryDto;
    }
}
