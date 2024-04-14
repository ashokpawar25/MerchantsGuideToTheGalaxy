package com.amaap.merchentguide.repository.db;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;

public interface InMemoryDatabase {
    IntergalacticTransactionUnit InsertIntoIntergalacticTransactionUnitTable(String intergalacticValue, String romanValue, int actualValue);

}
