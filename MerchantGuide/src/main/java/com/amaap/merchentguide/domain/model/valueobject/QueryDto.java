package com.amaap.merchentguide.domain.model.valueobject;

import java.util.Objects;

public class QueryDto {
    private final QueryType queryType;
    private final String queryContent;
    public QueryDto(QueryType queryType, String queryContent) {

        this.queryType = queryType;
        this.queryContent = queryContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryDto queryDto = (QueryDto) o;
        return queryType == queryDto.queryType && Objects.equals(queryContent, queryDto.queryContent);
    }
}
