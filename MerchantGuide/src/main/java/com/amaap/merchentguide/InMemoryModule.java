package com.amaap.merchentguide;

import com.amaap.merchentguide.controller.GalaxyController;
import com.amaap.merchentguide.controller.IntergalacticUnitController;
import com.amaap.merchentguide.controller.MetalController;
import com.amaap.merchentguide.controller.QueryController;
import com.amaap.merchentguide.domain.service.UnitConverter;
import com.amaap.merchentguide.domain.service.UnitQueryProcessor;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.repository.db.InMemoryDatabase;
import com.amaap.merchentguide.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.merchentguide.repository.impl.InMemoryIntergalacticUnitRepository;
import com.amaap.merchentguide.repository.impl.InMemoryMetalRepository;
import com.amaap.merchentguide.repository.impl.InMemoryQueryRepository;
import com.amaap.merchentguide.service.*;
import com.google.inject.AbstractModule;

public class InMemoryModule extends AbstractModule {
    @Override
    protected void configure()
    {
        bind(IntergalacticUnitController.class);
        bind(MetalController.class);
        bind(QueryController.class);
        bind(GalaxyController.class);
        bind(IntergalacticUnitService.class);
        bind(MetalService.class);
        bind(QueryService.class);
        bind(GalaxyService.class);
        bind(IntergalacticUnitRepository.class).to(InMemoryIntergalacticUnitRepository.class);
        bind(MetalRepository.class).to(InMemoryMetalRepository.class);
        bind(QueryRepository.class).to(InMemoryQueryRepository.class);
        bind(InMemoryDatabase.class).to(FakeInMemoryDatabase.class).asEagerSingleton();
        bind(UnitQueryProcessor.class);
        bind(ProcessorFactory.class);
        bind(UnitConverter.class);
    }
}
