package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

public class MetalService {
    MetalRepository metalRepository;
    public MetalService(MetalRepository metalRepository) {
        this.metalRepository = metalRepository;
    }

    public Metal create(String name, long credits) throws MetalAlreadyExistException, InvalidMetalDataException {
        return metalRepository.add(name,credits);
    }
}
