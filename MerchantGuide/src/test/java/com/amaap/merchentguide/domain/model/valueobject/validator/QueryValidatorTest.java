package com.amaap.merchentguide.domain.model.valueobject.validator;

import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import org.junit.jupiter.api.Test;

import static com.amaap.merchentguide.domain.model.valueobject.validator.QueryValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class QueryValidatorTest {

    @Test
    void shouldBeAbleToValidateQueryId()
    {
        assertTrue(isValidId(1));
        assertFalse(isValidId(0));
        assertFalse(isValidId(-1));
    }

    @Test
    void shouldBeAbleToValidateQueryType()
    {
        assertTrue(isValidQueryType(QueryType.UNIT_QUERY));
        assertFalse(isValidQueryType(null));
    }

    @Test
    void shouldBeAbleToValidateValidQueryContent()
    {
        assertTrue(isValidQueryContent("How much is glob prok?"));
        assertTrue(isValidQueryContent("how many Credits is glob prok Silver ?"));
        assertTrue(isValidQueryContent("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }

    @Test
    void shouldBeAbleToValidateInvalidQueryContent()
    {
        assertFalse(isValidQueryContent(null));
        assertFalse(isValidQueryContent(""));
        assertFalse(isValidQueryContent("How much is glob prok"));
    }
}