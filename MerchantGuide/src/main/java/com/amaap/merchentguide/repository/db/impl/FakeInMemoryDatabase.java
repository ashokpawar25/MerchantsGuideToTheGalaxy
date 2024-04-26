package com.amaap.merchentguide.repository.db.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<IntergalacticUnit> intergalacticUnits = new ArrayList<>();
    List<Metal> metals = new ArrayList<>();
    List<QueryDto> queries = new ArrayList<>();

    @Override
    public IntergalacticUnit InsertIntoIntergalacticUnitTable(
            String intergalacticValue, String romanValue, double actualValue)
            throws InvalidIntergalacticUnitDataException,
            IntergalacticUnitAlreadyExistException {

        Optional<IntergalacticUnit> existence = intergalacticUnits.stream().filter(unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue)).findFirst();
        if(existence.isPresent()) throw new IntergalacticUnitAlreadyExistException(intergalacticValue+" unit is already present");
        IntergalacticUnit intergalacticUnit = IntergalacticUnit.create(intergalacticValue,romanValue,actualValue);
        intergalacticUnits.add(intergalacticUnit);
        return intergalacticUnit;

    }

    @Override
    public IntergalacticUnit selectFromIntergalacticUnitTable(
            String intergalacticValue) {
        return intergalacticUnits.stream().filter
                (unit -> unit.getIntergalacticValue().equalsIgnoreCase(intergalacticValue))
                .findFirst().orElse(null);
    }

    @Override
    public Metal InsertIntoMetalTable(String name, double credits)
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
    public QueryDto insertIntoQueryTable(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        QueryDto queryDto = QueryDto.create(queryType,queryContent);
        queries.add(queryDto);
        return queryDto;
    }

    @Override
    public List<QueryDto> getAllQueries() {
        return queries;
    }
}
