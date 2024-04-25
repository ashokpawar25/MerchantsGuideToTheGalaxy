package com.amaap.merchentguide.domain.model.valueobject;

import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryContentException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryTypeException;

import java.util.Objects;

import static com.amaap.merchentguide.domain.model.valueobject.validator.QueryValidator.*;

public class QueryDto {
    private final QueryType queryType;
    private final String queryContent;
    public QueryDto(QueryType queryType, String queryContent) {
        this.queryType = queryType;
        this.queryContent = queryContent;
    }

    public static QueryDto create(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        if(!isValidQueryType(queryType)) throw new InvalidQueryTypeException("Invalid query type");
        if(!isValidQueryContent(queryContent)) throw new InvalidQueryContentException("Invalid query content");
        return new QueryDto(queryType,queryContent);
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public String getQueryContent() {
        return queryContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryDto queryDto = (QueryDto) o;
        return queryType == queryDto.queryType && Objects.equals(queryContent, queryDto.queryContent);
    }
}
