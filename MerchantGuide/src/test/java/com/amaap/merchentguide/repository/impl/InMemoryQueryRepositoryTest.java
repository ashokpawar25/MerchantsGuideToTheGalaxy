package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.service.QueryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryQueryRepositoryTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    QueryRepository queryRepository = new InMemoryQueryRepository(inMemoryDatabase);
    @Test
    void shouldBeAbleToAddQueryIntoDatabase()
    {
        // arrange
        QueryType queryType = QueryType.UnitQuery;
        String queryContent = "How much is glob prok ?";
        QueryDto expected = new QueryDto(queryType,queryContent);

        // act
        QueryDto actual = queryRepository.add(expected);

        // assert
        assertEquals(expected,actual);
    }
}