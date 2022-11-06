package com.hg.sketchbook.validations;

import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Set;

@Getter
@ToString
public class Address {
    private final Set<Role> roles;

    private final String city;
    private final String zipCode;
    private final String street;
    private final String houseNumber;
    private final String houseNumberAddition;

    private Address(Set<Role> roles,
                    String city,
                    String zipCode,
                    String street,
                    String houseNumber,
                    String houseNumberAddition) {
        this.roles = roles;
        this.city = city;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseNumberAddition = houseNumberAddition;
    }

    public static Result<Address, EnumSet<ValidationError>> of(Set<Role> roles,
                                                               String city,
                                                               String zipCode,
                                                               String street,
                                                               String houseNumber,
                                                               String houseNumberAddition) {
        var result = new Address(roles, city, zipCode, street, houseNumber, houseNumberAddition);

        var validations = roles.stream()
                .map(role -> role.validate(result))
                .reduce(EnumSet.noneOf(ValidationError.class),
                        (first, current) -> {
                            var res = EnumSet.copyOf(first);
                            res.addAll(current);

                            return res;
                        });

        if (!validations.isEmpty()) {
            return Result.failedWith(validations);
        }

        return Result.succeededWith(result);
    }
}
