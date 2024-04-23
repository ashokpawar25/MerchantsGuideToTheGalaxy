package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;

public class InMemoryQueryRepository implements QueryRepository {
    InMemoryDatabase inMemoryDatabase;
    public InMemoryQueryRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public QueryDto add(QueryDto queryDto) {
        return inMemoryDatabase.insertIntoQueryTable(queryDto);
    }
}
