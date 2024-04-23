package com.amaap.merchentguide.domain.model.valueobject;

import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryContentException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryIdException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryTypeException;
import com.amaap.merchentguide.domain.model.valueobject.validator.QueryValidator;

import java.util.Objects;

import static com.amaap.merchentguide.domain.model.valueobject.validator.QueryValidator.*;

public class QueryDto {
    private final int id;
    private final QueryType queryType;
    private final String queryContent;
    public QueryDto(int id ,QueryType queryType, String queryContent) {
        this.id = id;
        this.queryType = queryType;
        this.queryContent = queryContent;
    }

    public static QueryDto create(int id, QueryType queryType, String queryContent) throws InvalidQueryDataException {
        if(!isValidId(id)) throw new InvalidQueryIdException("Invalid Query Id:"+id);
        if(!isValidQueryType(queryType)) throw new InvalidQueryTypeException("Invalid query type");
        if(!isValidQueryContent(queryContent)) throw new InvalidQueryContentException("Invalid query content");
        return new QueryDto(id,queryType,queryContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryDto queryDto = (QueryDto) o;
        return id == queryDto.id && queryType == queryDto.queryType && Objects.equals(queryContent, queryDto.queryContent);
    }
}
