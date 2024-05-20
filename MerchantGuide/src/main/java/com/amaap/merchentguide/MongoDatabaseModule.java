package com.amaap.merchentguide;

import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.*;
import com.google.inject.AbstractModule;

public class MongoDatabaseModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(IntergalacticUnitRepository.class).to(MongoIntergalacticUnitRepository.class);
        bind(MetalRepository.class).to(MongoMetalRepository.class);
        bind(QueryRepository.class).to(MongoQueryRepository.class);
    }
}
