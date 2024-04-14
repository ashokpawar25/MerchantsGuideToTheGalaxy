package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.entity.ParsedUnitResponseDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.service.InputParser;
import com.amaap.merchentguide.domain.service.InputValidator;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOService {
    IntergalacticTransactionUnitService intergalacticUnitService;
    public IOService(IntergalacticTransactionUnitService intergalacticTransactionUnitService) {
        this.intergalacticUnitService = intergalacticTransactionUnitService;
    }

    public boolean readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.matches("^([a-zA-Z]+)\\s+is\\s+([IVXLCDM])$")) {
                    boolean isValidUnit = InputValidator.unitValidator(line);
                    if(isValidUnit)
                    {
                        ParsedUnitResponseDto parsedUnit = InputParser.parseUnit(line);
                        intergalacticUnitService.create(parsedUnit.interGalacticValue,parsedUnit.romanValue,parsedUnit.actualValue);
                    }
                }
            }
        } catch (IOException e) {
            return false;
        } catch (InvalidIntergalacticTransactionUnitDataException e) {
            return false;
        } catch (IntergalacticUnitAlreadyExistException e) {
            return false;
        }
        return true;
    }
}
