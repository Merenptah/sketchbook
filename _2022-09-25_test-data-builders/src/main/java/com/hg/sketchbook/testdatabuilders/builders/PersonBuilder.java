package com.hg.sketchbook.testdatabuilders.builders;

import com.hg.sketchbook.testdatabuilders.domain.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PersonBuilder {
    private String firstName = "Maxi";
    private String lastName = "Musterfrau";
    private LocalDate birthDate = LocalDate.now().minusYears(20);
    private Collection<AddressBuilder> addresses;

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withBirthDate(String birthDate) {
        this.birthDate = LocalDate.parse(birthDate);
        return this;
    }

    public PersonBuilder withAddress(AddressBuilder address) {
        if (addresses == null) {
            addresses = new ArrayList<>();
        }

        this.addresses.add(address);
        return this;
    }

    public PersonBuilder withAddresses(AddressBuilder... addresses) {
        this.addresses = Arrays.stream(addresses).toList();
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, birthDate, addresses == null ? null :
                addresses.stream().map(AddressBuilder::build).toList());
    }
}
