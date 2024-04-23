package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.QueryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueryControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    QueryRepository queryRepository = new InMemoryQueryRepository(inMemoryDatabase);
    QueryService queryService = new QueryService(queryRepository);
    QueryController queryController = new QueryController(queryService);
    
    @Test
    void shouldBeAbleToCreateQuery()
    {
        // arrange
        QueryType queryType = QueryType.UnitQuery;
        String queryContent = "How much is glob prok ?";
        Response expected = new Response(HttpStatus.OK,"Query created successfully");

        // act
        Response actual = queryController.create(queryType,queryContent);

        // assert
        assertEquals(expected,actual);
    }
}
