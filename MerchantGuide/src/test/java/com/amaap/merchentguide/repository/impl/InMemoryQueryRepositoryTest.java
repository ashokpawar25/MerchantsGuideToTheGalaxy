package com.amaap.merchentguide.repository.impl;

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

class InMemoryQueryRepositoryTest {
    InMemoryQueryRepository inMemoryQueryRepository;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        inMemoryQueryRepository = injector.getInstance(InMemoryQueryRepository.class);
    }

    @Test
    void shouldBeAbleToAddQueryIntoDatabase() throws InvalidQueryDataException {
        // arrange
        int id = 1;
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob prok ?";
        QueryDto expected = new QueryDto(queryType, queryContent);

        // act
        QueryDto actual = inMemoryQueryRepository.add(queryType, queryContent);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetAllQueriesFromDatabase() throws InvalidQueryDataException {
        // arrange
        List<QueryDto> expected = getQueries();

        // act
        inMemoryQueryRepository.add(QueryType.UNIT_QUERY, "How much is glob prok?");
        inMemoryQueryRepository.add(QueryType.METAL_QUERY, "how many Credits is glob prok Iron ?");
        List<QueryDto> actual = inMemoryQueryRepository.getAllQueries();

        // assert
        assertEquals(expected, actual);
    }
}