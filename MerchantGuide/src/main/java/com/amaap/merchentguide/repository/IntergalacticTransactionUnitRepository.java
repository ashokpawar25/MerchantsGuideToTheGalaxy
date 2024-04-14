package com.amaap.merchentguide.repository;

import com.amaap.merchentguide.domain.model.entity.IntergalacticTransactionUnit;

public interface IntergalacticTransactionUnitRepository {
    IntergalacticTransactionUnit add(String intergalacticValue, String romanValue, int actualValue);
}
