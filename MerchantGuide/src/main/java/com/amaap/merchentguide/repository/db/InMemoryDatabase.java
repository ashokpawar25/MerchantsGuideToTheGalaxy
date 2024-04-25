package com.amaap.merchentguide.repository.db;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

import java.util.List;

public interface InMemoryDatabase {
    IntergalacticUnit InsertIntoIntergalacticUnitTable(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException, IntergalacticUnitAlreadyExistException;

    IntergalacticUnit selectFromIntergalacticUnitTable(String intergalacticValue);

    Metal InsertIntoMetalTable(String name, double credits) throws MetalAlreadyExistException, InvalidMetalDataException;
    Metal selectFromMetalTable(String name);

    QueryDto insertIntoQueryTable(QueryType queryType, String queryContent) throws InvalidQueryDataException;

    List<QueryDto> getAllQueries();
}
