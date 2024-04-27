package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.model.entity.IntergalacticUnit;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.service.ProcessorFactory;
import com.amaap.merchentguide.domain.service.QueryProcessor;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.domain.service.parser.InputParser;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;
import jakarta.inject.Inject;

import java.io.*;
import java.util.List;

import static com.amaap.merchentguide.domain.service.validator.InputValidator.metalCreditsValidator;
import static com.amaap.merchentguide.domain.service.validator.InputValidator.unitValidator;

public class GalaxyService {
    private final IntergalacticUnitService intergalacticUnitService;
    private final MetalService metalService;
    private final QueryService queryService;
    private final ProcessorFactory processorFactory;

    @Inject
    public GalaxyService(IntergalacticUnitService intergalacticUnitService, MetalService metalService, QueryService queryService, ProcessorFactory processorFactory) {
        this.intergalacticUnitService = intergalacticUnitService;
        this.metalService = metalService;
        this.queryService = queryService;
        this.processorFactory = processorFactory;
    }

    public boolean readFile(String filePath) throws InvalidInputFileDataException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^([a-zA-Z]+)\\s+is\\s+([IVXLCDM])$")) {
                    boolean isValidUnit = unitValidator(line);
                    if (isValidUnit) {
                        IntergalacticUnit parsedUnit = InputParser.parseUnit(line);
                        intergalacticUnitService.create(parsedUnit.getIntergalacticValue(), parsedUnit.getRomanValue(), parsedUnit.getActualValue());
                    }
                } else if (line.matches("^([a-zA-Z]+(?:\\s+[a-zA-Z]+)*)\\s+([a-zA-Z]+)\\s+is\\s+(\\d+)\\s+Credits$")) {
                    boolean isValidMetal = metalCreditsValidator(line);
                    if (isValidMetal) {
                        MetalDto metalDto = InputParser.parseMetal(line, intergalacticUnitService);
                        metalService.create(metalDto.metal, metalDto.credits);
                    }
                } else if (line.endsWith("?")) {
                    QueryDto queryDto = InputParser.parseQuery(line);
                    queryService.create(queryDto.getQueryType(), queryDto.getQueryContent());
                }
                else {
                    throw new InvalidInputFileDataException("file data is invalid");
                }
            }
        } catch (IOException | InvalidIntergalacticUnitDataException | IntergalacticUnitAlreadyExistException |
                 InvalidMetalDataException | MetalAlreadyExistException | InvalidRomanValueException |
                 InvalidQueryDataException e) {
            return false;
        }
        return true;
    }

    public String processQueries() throws InvalidRomanValueException {
        List<QueryDto> queries = queryService.getAllQueries();
        StringBuilder finalResult = new StringBuilder();
        for(QueryDto query:queries)
        {
            QueryProcessor queryProcessor = processorFactory.getProcessor(query.getQueryType());
            String result = queryProcessor.processQuery(query.getQueryContent());
            finalResult.append("\n").append(result);
        }
        return finalResult.toString();
    }
}