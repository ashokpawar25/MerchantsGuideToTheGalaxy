package com.amaap.merchentguide.service;

import com.amaap.merchentguide.domain.model.dto.IntergalacticUnitDto;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidIntergalacticTransactionUnitDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.service.InputParser;
import com.amaap.merchentguide.domain.service.InputValidator;
import com.amaap.merchentguide.domain.model.dto.MetalDto;
import com.amaap.merchentguide.repository.db.impl.exception.IntergalacticUnitAlreadyExistException;
import com.amaap.merchentguide.repository.db.impl.exception.MetalAlreadyExistException;

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
                else if (line.endsWith("Credits"))
                {
                    boolean isValidMetal = InputValidator.metalCreditsValidator(line);
                    if(isValidMetal)
                    {
                        MetalDto metalDto = InputParser.parseMetal(line);
                        metalService.create(metalDto.metal, metalDto.credits);
                    }
                }
            }
        } catch (IOException e) {
            return false;
        } catch (InvalidIntergalacticTransactionUnitDataException e) {
            return false;
        } catch (IntergalacticUnitAlreadyExistException e) {
            return false;
        } catch (InvalidMetalDataException e) {
            return false;
        } catch (MetalAlreadyExistException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
