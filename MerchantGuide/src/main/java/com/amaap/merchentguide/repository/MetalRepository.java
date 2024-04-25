package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

public interface MetalRepository {
    Metal add(String name, double credits) throws MetalAlreadyExistException, InvalidMetalDataException;
    Metal selectFromMetalTable(String name);
}
