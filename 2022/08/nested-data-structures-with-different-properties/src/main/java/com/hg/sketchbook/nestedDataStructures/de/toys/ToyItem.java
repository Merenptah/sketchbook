package com.hg.sketchbook.nestedDataStructures.de.toys;

import com.hg.sketchbook.nestedDataStructures.Item;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ToyItem extends Item {
  private String securityAdvice;

  public ToyItem(String name, double price, String securityAdvice) {
    super(name, price);
    this.securityAdvice = securityAdvice;
  }
}
