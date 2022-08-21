package com.hg.sketchbook.memento;

import com.hg.sketchbook.memento.Person.Memento;

public class Demo {

  public static void main(String[] args) {
    var memento = new Memento.MementoBuilder()
        .fullName("Marge Simpson")
        .address("Somewhere in Springfield")
        .build();

    var person = memento.recreatePerson();

    System.out.println(person.writeLetter("Ned", "get off my lawn."));
    System.out.println(person.moveTo("Star City").createSnapshot());

  }
}
