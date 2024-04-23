package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.repository.QueryRepository;

public class QueryService {
    private final QueryRepository queryRepository;
    public QueryService(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    public QueryDto create(QueryType queryType, String queryContent) {
        QueryDto query = new QueryDto(queryType,queryContent);
        return queryRepository.add(query);
    }
}
