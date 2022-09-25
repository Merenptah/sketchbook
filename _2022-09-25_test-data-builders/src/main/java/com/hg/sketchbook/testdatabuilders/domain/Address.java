package com.hg.sketchbook.testdatabuilders.domain;

public record Address(String city, String zipCode, String street, String houseNumber,
                      AddressType addressType) {
    public enum AddressType {
        MAIN_ADDRESS, SECONDARY_ADDRESS, COMPANY_ADDRESS
    }
}
