package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import jakarta.inject.Inject;

import java.util.List;

public class InMemoryQueryRepository implements QueryRepository {
    InMemoryDatabase inMemoryDatabase;
    @Inject
    public InMemoryQueryRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public QueryDto add(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        return inMemoryDatabase.insertIntoQueryTable(queryType,queryContent);
    }

    @Override
    public List<QueryDto> getAllQueries() {
        return inMemoryDatabase.getAllQueries();
    }
}
