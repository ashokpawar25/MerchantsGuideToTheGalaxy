package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.service.InvalidQueryProcessor;
import com.amaap.merchentguide.domain.service.MetalQueryProcessor;
import com.amaap.merchentguide.domain.service.UnitQueryProcessor;

public class ProcessorFactory {
    public static QueryProcessor getProcessor(QueryType queryType, IntergalacticTransactionUnitService unitService, MetalService metalService) {
        if(queryType.equals(QueryType.UNIT_QUERY))
            return new UnitQueryProcessor(unitService);
        else if(queryType.equals(QueryType.METAL_QUERY))
            return new MetalQueryProcessor();
        else
            return new InvalidQueryProcessor();
    }
}
