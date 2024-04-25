package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.IntergalacticUnitService;
import com.amaap.merchentguide.service.QueryProcessor;

import static com.amaap.merchentguide.domain.service.UnitConverter.romanToDecimalConverter;

public class UnitQueryProcessor implements QueryProcessor {
    IntergalacticUnitService unitService;
    public UnitQueryProcessor(IntergalacticUnitService unitService) {
        this.unitService = unitService;
    }

    @Override
    public String processQuery(String queryContent) throws InvalidRomanValueException {
        String [] queryParts = queryContent.split(" is ");
        String [] units = queryParts[1].split(" ");
        StringBuilder romanValue = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i=0;i<units.length-1;i++)
        {
            IntergalacticUnit intergalacticUnit = unitService.get(units[i]);
            romanValue.append(intergalacticUnit.getRomanValue());
            answer.append(units[i]).append(" ");
        }
        long result = romanToDecimalConverter(romanValue.toString());
        answer.append("is ").append(result);
        return answer.toString();
    }
}
