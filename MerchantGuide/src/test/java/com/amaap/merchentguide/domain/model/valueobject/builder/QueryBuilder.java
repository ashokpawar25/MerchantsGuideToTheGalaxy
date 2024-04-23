package com.amaap.merchentguide.domain.model.valueobject.builder;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;

import java.util.List;

public class QueryBuilder {
    public static List<QueryDto> getQueries() {
        QueryDto queryDto1 = new QueryDto(1, QueryType.UNIT_QUERY,"How much is glob prok?");
        QueryDto queryDto2 = new QueryDto(2, QueryType.METAL_QUERY,"how many Credits is glob prok Iron ?");
        return List.of(queryDto1,queryDto2);
    }
}
