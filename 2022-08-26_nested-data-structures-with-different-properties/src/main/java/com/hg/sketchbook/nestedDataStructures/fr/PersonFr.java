package com.hg.sketchbook.nestedDataStructures.fr;

import com.hg.sketchbook.nestedDataStructures.Person;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PersonFr extends Person {
  private AddressFr deliveryAddress;
  private String education;

  public PersonFr(AddressFr deliveryAddress, String education) {
    this.deliveryAddress = deliveryAddress;
    this.education = education;
  }
}
