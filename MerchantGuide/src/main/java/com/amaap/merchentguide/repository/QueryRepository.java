package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;

public interface QueryRepository {
    QueryDto add(QueryDto queryDto);
}
