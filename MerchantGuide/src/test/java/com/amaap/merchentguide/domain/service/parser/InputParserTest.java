package com.amaap.merchentguide.domain.service.parser;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.service.parser.InputParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.amaap.merchentguide.domain.service.parser.InputParser.*;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void shouldBeAbleToParseIntergalacticUnit() throws IOException {
        // arrange
        String line = "glob is I";
        IntergalacticUnit expected = new IntergalacticUnit("glob","I",1);

        // act
        IntergalacticUnit actual = parseUnit(line);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToParseQuery() throws IOException {
        // arrange
        String line = "how much is pish tegj glob glob ?";
        QueryDto expected = new QueryDto(QueryType.UNIT_QUERY,"how much is pish tegj glob glob ?");

        // act
        QueryDto actual = parseQuery(line);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange & act
        InputParser inputParser = new InputParser();

        // assert
        assertNotNull(inputParser);
    }
}