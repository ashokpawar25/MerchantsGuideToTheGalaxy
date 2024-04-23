package com.amaap.merchentguide.domain.model.valueobject.validator;

import com.amaap.merchentguide.domain.model.valueobject.QueryType;

import java.util.EnumSet;

public class QueryValidator {
    public static boolean isValidId(int id) {
        return id>0;
    }

    public static boolean isValidQueryType(QueryType queryType) {
        for (QueryType type : QueryType.values()) {
            if (type.equals(queryType)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidQueryContent(String queryContent) {
        return queryContent != null && !queryContent.isEmpty() && queryContent.endsWith("?");
    }
}
