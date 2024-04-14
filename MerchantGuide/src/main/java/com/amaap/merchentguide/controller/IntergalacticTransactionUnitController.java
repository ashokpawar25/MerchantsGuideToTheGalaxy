package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.valueobject.HttpStatus;
import com.amaap.merchentguide.domain.model.valueobject.Response;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;

public class IntergalacticTransactionUnitController {

    IntergalacticTransactionUnitService intergalacticTransactionUnitService;

    public IntergalacticTransactionUnitController(IntergalacticTransactionUnitService intergalacticTransactionUnitService) {
        this.intergalacticTransactionUnitService = intergalacticTransactionUnitService;
    }


    public Response create(String intergalacticValue, String romanValue, int actualValue) throws InvalidIntergalacticTransactionUnitDataException {
        try
        {
            intergalacticTransactionUnitService.create(intergalacticValue,romanValue,actualValue);
            return new Response(HttpStatus.OK,"Intergalactic unit created");
        }
        catch (InvalidIntergalacticTransactionUnitDataException exception)
        {
            return new Response(HttpStatus.BADREQUEST,exception.getMessage());
        } catch (IntergalacticUnitAlreadyExistException exception) {
            return new Response(HttpStatus.CONFLICT,exception.getMessage());
        }
    }

    public IntergalacticTransactionUnit get(String intergalacticValue) {
        return intergalacticTransactionUnitService.get(intergalacticValue);
    }
}

