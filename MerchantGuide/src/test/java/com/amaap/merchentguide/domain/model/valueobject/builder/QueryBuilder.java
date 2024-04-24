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

    public static List<QueryDto> getAllQueries() {
        QueryDto queryDto1 = new QueryDto(1, QueryType.UNIT_QUERY,"how much is pish tegj glob glob ?");
        QueryDto queryDto2 = new QueryDto(2, QueryType.METAL_QUERY,"how many Credits is glob prok Silver ?");
        QueryDto queryDto3 = new QueryDto(3, QueryType.METAL_QUERY,"how many Credits is glob prok Gold ?");
        QueryDto queryDto4 = new QueryDto(4, QueryType.METAL_QUERY,"how many Credits is glob prok Iron ?");
        QueryDto queryDto5 = new QueryDto(5, QueryType.INVALID_QUERY,"how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
        return List.of(queryDto1,queryDto2,queryDto3,queryDto4,queryDto5);
    }
}
