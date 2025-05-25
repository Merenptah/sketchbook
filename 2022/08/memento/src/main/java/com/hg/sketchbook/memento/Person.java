package com.hg.sketchbook.memento;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

  private String name;

  private String address;

  public String writeLetter(String toPerson, String content) {
    return String.format("%s\n\nDear %s,\n\n%s. \n\nYours truly, %s",
        address,
        toPerson,
        content,
        name);
  }

  public Person moveTo(String newAddress) {
    return new Person(name, newAddress);
  }

  public Memento createSnapshot() {
    return Memento.builder().fullName(name).address(address).build();
  }

  @Builder
  @ToString
  public static class Memento {

    String fullName;

    String address;

    Person recreatePerson() {
      return new Person(fullName, address);
    }
  }
}
