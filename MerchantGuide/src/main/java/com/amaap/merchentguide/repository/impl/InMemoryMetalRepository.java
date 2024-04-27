package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import jakarta.inject.Inject;

public class InMemoryMetalRepository implements MetalRepository {
    private final InMemoryDatabase inMemoryDatabase;
    @Inject
    public InMemoryMetalRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public Metal add(String name, double credits) throws MetalAlreadyExistException, InvalidMetalDataException {
        return inMemoryDatabase.InsertIntoMetalTable(name,credits);
    }

    public Metal selectFromMetalTable(String name) {
        return inMemoryDatabase.selectFromMetalTable(name);
    }
}
