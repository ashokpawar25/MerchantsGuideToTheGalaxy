package com.amaap.merchentguide.domain.service;

import com.amaap.merchentguide.service.QueryProcessor;

public class InvalidQueryProcessor implements QueryProcessor {
    @Override
    public String processQuery(String queryContent) {
        return "I have no idea what you are talking about";
    }
}
