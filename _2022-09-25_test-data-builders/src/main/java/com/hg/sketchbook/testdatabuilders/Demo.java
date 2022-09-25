package com.hg.sketchbook.testdatabuilders;

import com.hg.sketchbook.testdatabuilders.domain.Address;

import static com.hg.sketchbook.testdatabuilders.builders.AddressBuilder.anAddress;
import static com.hg.sketchbook.testdatabuilders.builders.PersonBuilder.aPerson;

public class Demo {

    public static void main(String[] args) {
        var person = aPerson()
                .withBirthDate("2000-01-01")
                .withAddresses(
                        anAddress().withAddressType(Address.AddressType.COMPANY_ADDRESS))
                .build();

        System.out.println(person);
    }
}
