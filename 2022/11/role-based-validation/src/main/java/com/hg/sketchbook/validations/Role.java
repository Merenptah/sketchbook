package com.hg.sketchbook.validations;

import org.apache.commons.lang.StringUtils;

import java.util.EnumSet;
import java.util.function.Function;

public enum Role {
    LOTTERY_ADDRESS(a -> {
        var res = EnumSet.noneOf(ValidationError.class);

        if (StringUtils.isBlank(a.getStreet())) {
            res.add(ValidationError.MISSING_STREET);
        }
        if (StringUtils.isBlank(a.getHouseNumber())) {
            res.add(ValidationError.MISSING_HOUSE_NUMBER);
        }

        return res;
    }),
    CITY_INDICATING_ADDRESS(a -> {
        var res = EnumSet.noneOf(ValidationError.class);

        if (StringUtils.isBlank(a.getCity())) {
            res.add(ValidationError.MISSING_CITY);
        }
        if (StringUtils.isBlank(a.getZipCode())) {
            res.add(ValidationError.MISSING_ZIP_CODE);
        }

        return res;
    }),
    MAIN_ADDRESS(a -> {
        var res = EnumSet.noneOf(ValidationError.class);

        if (StringUtils.isBlank(a.getCity())) {
            res.add(ValidationError.MISSING_CITY);
        }
        if (StringUtils.isBlank(a.getZipCode())) {
            res.add(ValidationError.MISSING_ZIP_CODE);
        }
        if (StringUtils.isBlank(a.getStreet())) {
            res.add(ValidationError.MISSING_STREET);
        }
        if (StringUtils.isBlank(a.getHouseNumber())) {
            res.add(ValidationError.MISSING_HOUSE_NUMBER);
        }

        return res;
    });

    private final Function<Address, EnumSet<ValidationError>> validator;

    private Role(Function<Address, EnumSet<ValidationError>> validator) {
        this.validator = validator;
    }

    public EnumSet<ValidationError> validate(Address address) {
        return validator.apply(address);
    }
}
