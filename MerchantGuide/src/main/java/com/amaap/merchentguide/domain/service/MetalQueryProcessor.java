package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.service.IntergalacticUnitService;
import com.amaap.merchentguide.service.MetalService;

import static com.amaap.merchentguide.domain.service.UnitConverter.romanToDecimalConverter;

public class MetalQueryProcessor implements QueryProcessor {
    private final MetalService metalService;
    IntergalacticUnitService intergalacticUnitService;
    public MetalQueryProcessor(MetalService metalService, IntergalacticUnitService intergalacticUnitService) {
        this.metalService = metalService;
        this.intergalacticUnitService = intergalacticUnitService;
    }

    @Override
    public String processQuery(String queryContent) throws InvalidRomanValueException {
        String [] queryParts = queryContent.split(" is ");
        String [] mainData = queryParts[1].split(" ");
        StringBuilder romanValue = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        String metal = mainData[mainData.length-2];
        for(int i = 0; i<mainData.length-2;i++)
        {
            IntergalacticUnit intergalacticUnit =intergalacticUnitService.get(mainData[i]);
            romanValue.append(intergalacticUnit.getRomanValue());
            answer.append(mainData[i]).append(" ");
        }
        answer.append(metal).append(" is ");
        long requiredUnits = romanToDecimalConverter(romanValue.toString());
        Metal metal1 = metalService.getMetal(metal);
        double metalCredits = metal1.getCredits();
        answer.append((int)(requiredUnits*metalCredits)).append(" Credits");
        return answer.toString();
    }
}
