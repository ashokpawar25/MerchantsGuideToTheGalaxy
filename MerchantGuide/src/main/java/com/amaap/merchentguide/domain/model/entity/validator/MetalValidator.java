package com.amaap.merchentguide.domain.model.entity.validator;

public class MetalValidator {
    public static boolean isInvalidMetalName(String name) {
        return name == null || name.isEmpty() || !name.matches("\\b\\w+\\b");
    }

    public static boolean isInvalidCredits(double credits) {
        return credits <= 0;
    }
}
