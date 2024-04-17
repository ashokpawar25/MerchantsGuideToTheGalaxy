package com.amaap.merchentguide.domain.service.io;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.service.io.parser.InputParser;
import com.amaap.merchentguide.domain.service.io.validator.InputValidator;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.domain.service.exception.InvalidRomanValueException;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;
import com.amaap.merchentguide.service.IntergalacticTransactionUnitService;
import com.amaap.merchentguide.service.MetalService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOService {
    IntergalacticTransactionUnitService intergalacticUnitService;
    MetalService metalService ;
    public IOService(IntergalacticTransactionUnitService intergalacticTransactionUnitService,MetalService metalService) {
        this.intergalacticUnitService = intergalacticTransactionUnitService;
        this.metalService = metalService;
    }

    public boolean readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^([a-zA-Z]+)\\s+is\\s+([IVXLCDM])$")) {
                    boolean isValidUnit = InputValidator.unitValidator(line);
                    if(isValidUnit)
                    {
                        IntergalacticUnitDto parsedUnit = InputParser.parseUnit(line);
                        intergalacticUnitService.create(parsedUnit.interGalacticValue,parsedUnit.romanValue,parsedUnit.actualValue);
                    }
                }
                else if (line.matches("^([a-zA-Z]+(?: [a-zA-Z]+)*) ([a-zA-Z]+) is (\\d+) Credits$"))
                {
                    boolean isValidMetal = InputValidator.metalCreditsValidator(line);
                    if(isValidMetal)
                    {
                        MetalDto metalDto = InputParser.parseMetal(line,intergalacticUnitService);
                        metalService.create(metalDto.metal, metalDto.credits);
                    }
                }
            }
        } catch (IOException | InvalidIntergalacticTransactionUnitDataException |
                 IntergalacticUnitAlreadyExistException | InvalidMetalDataException | MetalAlreadyExistException |
                 InvalidRomanValueException e) {
            return false;
        }
        return true;
    }
}
