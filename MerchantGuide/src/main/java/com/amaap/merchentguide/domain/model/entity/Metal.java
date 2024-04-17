package com.amaap.merchentguide.domain.model.entity;

import com.amaap.merchentguide.domain.model.entity.exception.InvalidCreditsException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalDataException;
import com.amaap.merchentguide.domain.model.entity.exception.InvalidMetalNameException;
import com.amaap.merchentguide.domain.model.entity.validator.MetalValidator;

import java.util.Objects;

public class Metal {
    private String name;
    private long credits;
    public Metal(String name, long credits) {
        this.name = name;
        this.credits = credits;
    }

    public static Metal create(String name, long credits) throws InvalidMetalDataException {
        if(MetalValidator.isInvalidMetalName(name)) throw new InvalidMetalNameException(name+" is invalid");
        if(MetalValidator.isInvalidCredits(credits)) throw new InvalidCreditsException(credits+" are not valid");
        return new Metal(name,credits);
    }

    public String getName() {
        return name;
    }

    public long getCredits() {
        return credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metal metal = (Metal) o;
        return credits == metal.credits && Objects.equals(name, metal.name);
    }

}
