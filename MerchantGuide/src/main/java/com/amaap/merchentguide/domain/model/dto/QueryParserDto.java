package com.amaap.merchentguide.domain.model.dto;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;

public class QueryParserDto {
    public QueryType queryType;
    public String queryContent;
    public QueryParserDto(QueryType queryType, String queryContent) {
        this.queryType = queryType;
        this.queryContent = queryContent;
    }
}
