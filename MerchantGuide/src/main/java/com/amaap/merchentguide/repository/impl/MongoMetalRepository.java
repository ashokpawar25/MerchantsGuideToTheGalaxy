package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.Metal;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoMetalRepository implements MetalRepository {

    private final MongoClient mongoClient;

    public MongoMetalRepository()
    {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public Metal add(String name, double credits) throws MetalAlreadyExistException, InvalidMetalDataException {
        mongoClient.getDatabase("merchant-guide").getCollection("metal").insertOne(
                new Document()
                        .append("name",name)
                        .append("credits",credits));
        return new Metal(name,credits);
    }

    @Override
    public Metal selectFromMetalTable(String name) {
        Document document = mongoClient.getDatabase("merchant-guide").getCollection("metal")
                .find(eq("name",name))
                .first();
        assert document != null;
        return new Metal(
                document.getString("name"),
                document.getDouble("credits")
        );
    }
}
