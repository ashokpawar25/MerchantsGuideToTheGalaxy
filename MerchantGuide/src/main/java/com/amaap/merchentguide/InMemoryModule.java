package com.amaap.merchentguide;

import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.GalaxyService;
import com.amaap.merchentguide.service.ProcessorFactory;
import com.google.inject.AbstractModule;

public class InMemoryModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(IntergalacticUnitRepository.class).to(InMemoryIntergalacticUnitRepository.class);
        bind(MetalRepository.class).to(InMemoryMetalRepository.class);
        bind(QueryRepository.class).to(InMemoryQueryRepository.class);
        bind(ProcessorFactory.class);
        bind(GalaxyService.class).to(GalaxyService.class);
    }
}
