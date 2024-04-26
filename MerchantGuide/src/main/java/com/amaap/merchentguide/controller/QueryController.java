package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.service.QueryService;
import jakarta.inject.Inject;

import java.util.List;

public class QueryController {
    private final QueryService queryService;
    @Inject
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    public Response create(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        queryService.create(queryType,queryContent);
        return new Response(HttpStatus.OK,"Query created successfully");
    }

    public List<QueryDto> getAllQueries() {
        return queryService.getAllQueries();
    }
}
