package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import static com.mongodb.client.model.Accumulators.first;
import static com.mongodb.client.model.Filters.eq;

public class MongoIntergalacticUnitRepository implements IntergalacticUnitRepository {
    private final MongoClient mongoClient;
    public MongoIntergalacticUnitRepository() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
    }

    @Override
    public IntergalacticUnit add(String intergalacticValue, String romanValue, double actualValue) throws InvalidIntergalacticUnitDataException, IntergalacticUnitAlreadyExistException {
        mongoClient.getDatabase("merchant-guide").getCollection("unit")
                .insertOne(new Document()
                        .append("intergalacticValue",intergalacticValue)
                        .append("romanValue",romanValue)
                        .append("actualValue",actualValue));
        return new IntergalacticUnit(intergalacticValue,romanValue,actualValue);
    }

    @Override
    public IntergalacticUnit find(String intergalacticValue) {
        Document document = mongoClient.getDatabase("merchant-guide")
                .getCollection("unit")
                .find(eq("intergalacticValue", intergalacticValue))
                .first();
        IntergalacticUnit intergalacticUnit = new IntergalacticUnit(
                document.getString("intergalacticValue"),
                document.getString("romanValue"),
                document.getDouble("actualValue")
        );
        return intergalacticUnit;
    }
}
