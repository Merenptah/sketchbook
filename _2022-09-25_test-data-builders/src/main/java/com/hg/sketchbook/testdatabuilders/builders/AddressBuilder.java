package com.hg.sketchbook.testdatabuilders.builders;

import com.hg.sketchbook.testdatabuilders.domain.Address;

public class AddressBuilder {
    private String city = "Berlin";
    private String zipCode = "10000";
    private String street = "Musterstr.";
    private String houseNumber = "1";
    private Address.AddressType addressType = Address.AddressType.MAIN_ADDRESS;

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressBuilder withAddressType(Address.AddressType addressType) {
        this.addressType = addressType;
        return this;
    }

    public Address build() {
        return new Address(city, zipCode, street, houseNumber, addressType);
    }
}
