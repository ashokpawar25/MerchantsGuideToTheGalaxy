package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.model.dto.QueryParserDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.valueobject.QueryDto;
import com.amaap.merchentguide.domain.model.valueobject.exception.InvalidQueryDataException;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.domain.service.io.parser.InputParser;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.exception.InvalidInputFileDataException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.amaap.merchentguide.domain.service.io.validator.InputValidator.metalCreditsValidator;
import static com.amaap.merchentguide.domain.service.io.validator.InputValidator.unitValidator;

public class GalaxyService {
    private final IntergalacticTransactionUnitService intergalacticUnitService;
    private final MetalService metalService;
    private final QueryService queryService;

    public GalaxyService(IntergalacticTransactionUnitService intergalacticTransactionUnitService, MetalService metalService, QueryService queryService) {
        this.intergalacticUnitService = intergalacticTransactionUnitService;
        this.metalService = metalService;
        this.queryService = queryService;
    }

    public boolean readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^([a-zA-Z]+)\\s+is\\s+([IVXLCDM])$")) {
                    boolean isValidUnit = unitValidator(line);
                    if (isValidUnit) {
                        IntergalacticUnitDto parsedUnit = InputParser.parseUnit(line);
                        intergalacticUnitService.create(parsedUnit.interGalacticValue, parsedUnit.romanValue, parsedUnit.actualValue);
                    }
                } else if (line.matches("^([a-zA-Z]+(?:\\s+[a-zA-Z]+)*)\\s+([a-zA-Z]+)\\s+is\\s+(\\d+)\\s+Credits$")) {
                    boolean isValidMetal = metalCreditsValidator(line);
                    if (isValidMetal) {
                        MetalDto metalDto = InputParser.parseMetal(line, intergalacticUnitService);
                        metalService.create(metalDto.metal, metalDto.credits);
                    }
                } else if (line.endsWith("?")) {
                    QueryParserDto queryDto = InputParser.parseQuery(line);
                    queryService.create(queryDto.queryType, queryDto.queryContent);
                }
                else {
                    throw new InvalidInputFileDataException("file data is invalid");
                }
            }
        } catch (IOException | InvalidIntergalacticTransactionUnitDataException |
                 IntergalacticUnitAlreadyExistException | InvalidMetalDataException | MetalAlreadyExistException |
                 InvalidRomanValueException | InvalidQueryDataException e) {
            return false;
        } catch (InvalidInputFileDataException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public String processQueries() throws InvalidRomanValueException {
        List<QueryDto> queries = queryService.getAllQueries();
        StringBuilder finalResult = new StringBuilder();
        for(QueryDto query:queries)
        {
            QueryProcessor queryProcessor = ProcessorFactory.getProcessor(query.getQueryType(),intergalacticUnitService,metalService);
            String result = queryProcessor.processQuery(query.getQueryContent());
            finalResult.append("\n").append(result);
        }
        return finalResult.toString();
    }
}
