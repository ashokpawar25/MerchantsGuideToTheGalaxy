package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.service.IntergalacticUnitService;

public class IntergalacticUnitController {

    IntergalacticUnitService intergalacticUnitService;

    public IntergalacticUnitController(IntergalacticUnitService intergalacticUnitService) {
        this.intergalacticUnitService = intergalacticUnitService;
    }


    public Response create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException {
        try
        {
            intergalacticUnitService.create(intergalacticValue,romanValue,actualValue);
            return new Response(HttpStatus.OK,"Intergalactic unit created");
        }
        catch (InvalidIntergalacticTransactionUnitDataException exception)
        {
            return new Response(HttpStatus.BADREQUEST,exception.getMessage());
        } catch (IntergalacticUnitAlreadyExistException exception) {
            return new Response(HttpStatus.CONFLICT,exception.getMessage());
        }
    }

    public IntergalacticUnit get(String intergalacticValue) {
        return intergalacticUnitService.get(intergalacticValue);
    }
}

