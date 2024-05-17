package com.amaap.merchentguide.domain.model.valueobject;

import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryContentException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryDtoTest {

    @Test
    void shouldBeAbleToCreateQuery() throws InvalidQueryDataException {
        // arrange
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob glob ?";
        QueryDto expected = new QueryDto(queryType, queryContent);

        // act
        QueryDto actual = QueryDto.create(queryType, queryContent);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidQueryTypeIsPassed() {
        assertThrows(InvalidQueryTypeException.class, () -> QueryDto.create(null, "how much is glob prok?"));
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidContentIsPassed() {
        assertThrows(InvalidQueryContentException.class, () -> QueryDto.create(QueryType.UNIT_QUERY, null));
        assertThrows(InvalidQueryContentException.class, () -> QueryDto.create(QueryType.UNIT_QUERY, ""));
        assertThrows(InvalidQueryContentException.class, () -> QueryDto.create(QueryType.UNIT_QUERY, "how much is glob prok"));
    }

    @Test
    void shouldBeAbleToCompareInstanceOfClass()
    {
        // arrange
        QueryDto queryDto1 = new QueryDto(QueryType.UNIT_QUERY,"how much is glob glob?");
        QueryDto queryDto2 = new QueryDto(QueryType.UNIT_QUERY,"how much is glob glob?");
        QueryDto queryDto3 = new QueryDto(QueryType.METAL_QUERY,"how much is glob glob?");
        QueryDto queryDto4 = new QueryDto(QueryType.UNIT_QUERY,"how much is glob prok?");
        QueryDto queryDto5 = new QueryDto(QueryType.METAL_QUERY,"how much is glob prok?");
        Object object = new Object();

        // act & assert
        assertTrue(queryDto1.equals(queryDto1));
        assertTrue(queryDto1.equals(queryDto2));
        assertFalse(queryDto1.equals(queryDto3));
        assertFalse(queryDto1.equals(queryDto4));
        assertFalse(queryDto1.equals(queryDto5));
        assertFalse(queryDto1.equals(object));
        assertFalse(queryDto1.equals(null));
    }
}