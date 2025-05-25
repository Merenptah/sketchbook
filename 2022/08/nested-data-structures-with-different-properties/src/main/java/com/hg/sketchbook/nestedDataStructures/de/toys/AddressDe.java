package com.hg.sketchbook.nestedDataStructures.de.toys;

import com.hg.sketchbook.nestedDataStructures.Address;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressDe extends Address {
  private String street;

  public AddressDe(String zipCode, String street) {
    super(zipCode);
    this.street = street;
  }
}
