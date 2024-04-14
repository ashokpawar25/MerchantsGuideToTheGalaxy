package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.MetalService;

public class MetalController {
    MetalService metalService;
    public MetalController(MetalService metalService) {
        this.metalService = metalService;
    }

    public Metal create(String name, long credits) throws MetalAlreadyExistException {
        return metalService.create(name,credits);
    }
}
