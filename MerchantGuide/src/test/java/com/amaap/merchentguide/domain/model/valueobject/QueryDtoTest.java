package com.amaap.merchentguide.domain.model.valueobject;

import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryContentException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryIdException;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QueryDtoTest {

    @Test
    void shouldBeAbleToCreateQuery() throws InvalidQueryDataException {
        // arrange
        int id = 1;
        QueryType queryType = QueryType.UNIT_QUERY;
        String queryContent = "How much is glob glob ?";
        QueryDto expected = new QueryDto(id,queryType,queryContent);

        // act
        QueryDto actual = QueryDto.create(id,queryType,queryContent);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidIdIsPassed()
    {
        assertThrows(InvalidQueryIdException.class,()-> QueryDto.create(0,QueryType.UNIT_QUERY,"how much is glob prok?"));
        assertThrows(InvalidQueryIdException.class,()-> QueryDto.create(-1,QueryType.UNIT_QUERY,"how much is glob prok?"));
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidQueryTypeIsPassed()
    {
        assertThrows(InvalidQueryTypeException.class,()-> QueryDto.create(1,null,"how much is glob prok?"));
    }

    @Test
    void shouldBeAbleToThrowExceptionWhenInvalidContentIsPassed()
    {
        assertThrows(InvalidQueryContentException.class,()-> QueryDto.create(1,QueryType.UNIT_QUERY,null));
        assertThrows(InvalidQueryContentException.class,()-> QueryDto.create(2,QueryType.UNIT_QUERY,""));
        assertThrows(InvalidQueryContentException.class,()-> QueryDto.create(3,QueryType.UNIT_QUERY,"how much is glob prok"));
    }
}