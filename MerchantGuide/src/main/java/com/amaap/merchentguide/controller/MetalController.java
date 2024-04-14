package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.HttpStatus;
import com.amaap.merchentguide.domain.model.valueobject.Response;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.MetalService;

public class MetalController {
    MetalService metalService;
    public MetalController(MetalService metalService) {
        this.metalService = metalService;
    }

    public Response create(String name, long credits) {
        try {
            metalService.create(name,credits);
            return new Response(HttpStatus.OK,"Metal created successfully");
        }
        catch (InvalidMetalDataException exception)
        {
            return new Response(HttpStatus.BADREQUEST,exception.getMessage());
        }
        catch (MetalAlreadyExistException exception)
        {
            return new Response(HttpStatus.CONFLICT,exception.getMessage());
        }
    }
}
