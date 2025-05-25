package com.hg.sketchbook.testdatabuilders.domain;

import lombok.Value;

import java.time.LocalDate;
import java.util.Collection;

@Value
public class Person {
    String firstName;
    String lastName;
    LocalDate birthDate;
    Collection<Address> addresses;
}
