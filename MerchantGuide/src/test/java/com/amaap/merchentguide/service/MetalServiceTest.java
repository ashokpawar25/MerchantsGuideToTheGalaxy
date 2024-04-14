package com.amaap.merchentguide.service;

import com.amaap.merchentguide.controller.MetalController;
import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetalServiceTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();
    MetalRepository metalRepository = new InMemoryMetalRepository(inMemoryDatabase);
    MetalService metalService = new MetalService(metalRepository);


    @Test
    void shouldBeAbleToCreateMetal() throws MetalAlreadyExistException {
        // arrange
        String name = "Silver";
        long credits = 17;
        Metal expected = new Metal(name,credits);

        // act
        Metal actual = metalService.create(name,credits);

        // assert
        assertEquals(expected,actual);

    }

}