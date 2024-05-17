package com.amaap.merchentguide.service;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.amaap.merchentguide.domain.model.valueobject.builder.QueryBuilder.getQueries;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryServiceTest {
    QueryService queryService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        queryService = injector.getInstance(QueryService.class);
    }

    @Test
    void shouldBeAbleToCreateQuery() throws InvalidQueryDataException {
        // arrange
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob prok ?";
        QueryDto expected = new QueryDto(queryType, queryContent);

        // act
        QueryDto actual = queryService.create(queryType, queryContent);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetAllQueries() throws InvalidQueryDataException {
        // arrange
        List<QueryDto> expected = getQueries();

        // act
        queryService.create(QueryType.UNIT_QUERY, "How much is glob prok?");
        queryService.create(QueryType.METAL_QUERY, "how many Credits is glob prok Iron ?");
        List<QueryDto> actual = queryService.getAllQueries();

        // assert
        assertEquals(expected, actual);
    }
}