package com.amaap.merchentguide.controller;

import com.amaap.merchentguide.domain.model.entity.Metal;
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
    void shouldBeAbleToCreateMetal() throws MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = metalController.create(name,credits);

        // assert
        assertEquals(expected,actual);

    }
}
