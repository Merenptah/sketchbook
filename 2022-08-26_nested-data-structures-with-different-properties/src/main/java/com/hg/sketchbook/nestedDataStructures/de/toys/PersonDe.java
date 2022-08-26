package com.hg.sketchbook.nestedDataStructures.de.toys;

import com.hg.sketchbook.nestedDataStructures.Person;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PersonDe extends Person {
  private AddressDe deliveryAddress;
  private String vat;

  public PersonDe(AddressDe deliveryAddress, String vat) {
    this.deliveryAddress = deliveryAddress;
    this.vat = vat;
  }
}
