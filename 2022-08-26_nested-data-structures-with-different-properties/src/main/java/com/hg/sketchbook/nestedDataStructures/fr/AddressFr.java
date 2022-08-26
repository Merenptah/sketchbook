package com.hg.sketchbook.nestedDataStructures.fr;

import com.hg.sketchbook.nestedDataStructures.Address;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddressFr extends Address {
  private String departement;

  public AddressFr(String zipCode, String departement) {
    super(zipCode);
    this.departement = departement;
  }
}
