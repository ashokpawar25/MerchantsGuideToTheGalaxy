package com.amaap.merchentguide.repository.impl;

import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.QueryType;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.repository.QueryRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoQueryRepository implements QueryRepository {
    private final MongoClient mongoClient;

    public MongoQueryRepository()
    {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
    }
    @Override
    public QueryDto add(QueryType queryType, String queryContent) throws InvalidQueryDataException {
        mongoClient.getDatabase("merchant-guide").getCollection("query").insertOne(
                new Document()
                        .append("queryType",queryType.toString())
                        .append("queryContent",queryContent)
        );
        return new QueryDto(queryType,queryContent);
    }

    @Override
    public List<QueryDto> getAllQueries() {
        List<QueryDto> queries = new ArrayList<>();
        MongoCollection<Document> document = mongoClient.getDatabase("merchant-guide").getCollection("query");
        try (MongoCursor<Document> cursor = document.find().iterator())
        {
            while (cursor.hasNext())
            {
                Document document1 = cursor.next();
                QueryType queryType = QueryType.valueOf(document1.getString("queryType"));
                queries.add(
                        new QueryDto(queryType,document1.getString("queryContent"))
                        );
            }
        }

        return queries;
    }
}
