package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.controller.dto.HttpStatus;
import com.amaap.merchentguide.controller.dto.Response;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.service.MetalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MetalControllerTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    MetalRepository metalRepository = new InMemoryMetalRepository(inMemoryDatabase);
    MetalService metalService = new MetalService(metalRepository);
    MetalController metalController = new MetalController(metalService);

    @Test
    void shouldBeAbleToCreateMetal() throws MetalAlreadyExistException, InvalidMetalDataException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Response expected = new Response(HttpStatus.OK,"Metal created successfully");

        // act
        Response actual = metalController.create(name,credits);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetConflictResponseWhenTryToAddDuplicateMetal()
    {
        // arrange
        metalController.create("Silver",1000);
        Response expected = new Response(HttpStatus.CONFLICT, "Silver is already present");

        // act
        Response actual = metalController.create("Silver",1000);

        // assert
        assertEquals(expected,actual);
    }

    @Test
    void shouldBeAbleToGetMetalByName() throws InvalidMetalDataException, MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected  = new Metal(name,credits);

        // act
        metalController.create(name,credits);
        Metal actual = metalController.getMetal(name);

        // assert
        assertEquals(expected,actual);
    }
}
