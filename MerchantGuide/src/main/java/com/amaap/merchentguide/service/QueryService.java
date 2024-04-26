package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.QueryRepository;
import jakarta.inject.Inject;

import java.util.List;

public class QueryService {
    private final QueryRepository queryRepository;
    @Inject
    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public QueryDto create(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        return queryRepository.add(queryType,queryContent);
    }

    public List<QueryDto> getAllQueries() {
        return queryRepository.getAllQueries();
    }
}
