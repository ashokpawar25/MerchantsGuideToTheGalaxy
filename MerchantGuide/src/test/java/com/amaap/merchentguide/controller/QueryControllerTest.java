package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
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

public class QueryControllerTest {
    QueryController queryController;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        queryController = injector.getInstance(QueryController.class);
    }

    @Test
    void shouldBeAbleToGetOkResponseWhenCreateQueryQuery() throws InvalidQueryDataException {
        // arrange
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob prok ?";
        Response expected = new Response(HttpStatus.OK, "Query created successfully");

        // act
        Response actual = queryController.create(queryType, queryContent);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetAllQueries() throws InvalidQueryDataException {
        // arrange
        List<QueryDto> expected = getQueries();

        // act
        queryController.create(QueryType.UNIT_QUERY, "How much is glob prok?");
        queryController.create(QueryType.METAL_QUERY, "how many Credits is glob prok Iron ?");
        List<QueryDto> actual = queryController.getAllQueries();

        // assert
        assertEquals(expected, actual);
    }
}
