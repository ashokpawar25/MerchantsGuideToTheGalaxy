package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.service.QueryService;

public class QueryController {
    private final QueryService queryService;
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }

    public Response create(QueryType queryType, String queryContent) {
        queryService.create(queryType,queryContent);
        return new Response(HttpStatus.OK,"Query created successfully");
    }
}
