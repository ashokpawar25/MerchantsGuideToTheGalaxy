package com.amaap.merchentguide.service;

import com.amaap.merchentguide.AppModule;
import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntergalacticUnitServiceTest {
    IntergalacticUnitService intergalacticUnitService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new AppModule());
        intergalacticUnitService = injector.getInstance(IntergalacticUnitService.class);
    }

    @Test
    void shouldBeAbleToCreateIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue, romanValue, actualValue);

        // act
        IntergalacticUnit actual = intergalacticUnitService.create(intergalacticValue, romanValue, actualValue);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetIntergalacticTransactionUnitByIntergalacticTransactionUnit() throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        // arrange
        String intergalacticValue = "glob";
        String romanValue = "I";
        int actualValue = 1;
        IntergalacticUnit expected = new IntergalacticUnit(intergalacticValue, romanValue, actualValue);

        // act
        intergalacticUnitService.create(intergalacticValue, romanValue, actualValue);
        IntergalacticUnit actual = intergalacticUnitService.get(intergalacticValue);

        // assert
        assertEquals(expected, actual);
    }
}