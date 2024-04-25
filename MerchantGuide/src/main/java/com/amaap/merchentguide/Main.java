package com.amaap.merchentguide;

import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.repository.IntergalacticUnitRepository;
import com.amaap.merchentguide.repository.MetalRepository;
import com.amaap.merchentguide.repository.QueryRepository;
import com.amaap.merchentguide.service.GalaxyService;
import com.amaap.merchentguide.service.ProcessorFactory;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) throws InvalidInputFileDataException, InvalidRomanValueException {
        Injector injector = Guice.createInjector(new InMemoryModule());
        IntergalacticUnitRepository intergalacticUnitRepository = injector.getInstance(IntergalacticUnitRepository.class);
        MetalRepository metalRepository = injector.getInstance(MetalRepository.class);
        QueryRepository queryRepository = injector.getInstance(QueryRepository.class);
        ProcessorFactory processorFactory = injector.getInstance(ProcessorFactory.class);
        GalaxyService galaxyService = injector.getInstance(GalaxyService.class);
        galaxyService.readFile("src/main/java/com/amaap/merchentguide/resources/inputData.txt");
        String result = galaxyService.processQueries();
        System.out.println(result);
    }
}