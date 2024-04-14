package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

public interface MetalRepository {
    Metal add(String name, long credits) throws MetalAlreadyExistException;
}
