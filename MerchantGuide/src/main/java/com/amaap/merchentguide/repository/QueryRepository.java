package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;

import java.util.List;

public interface QueryRepository {
    QueryDto add(QueryType queryType, String queryContent) throws InvalidQueryDataException;

    List<QueryDto> getAllQueries();
}
