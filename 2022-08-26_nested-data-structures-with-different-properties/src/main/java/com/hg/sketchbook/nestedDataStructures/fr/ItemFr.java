package com.hg.sketchbook.nestedDataStructures.fr;

import com.hg.sketchbook.nestedDataStructures.Item;
import lombok.Getter;

@Getter
public class ItemFr extends Item {
  private double tax;

  public ItemFr(String name, double price, double tax) {
    super(name, price);
    this.tax = tax;
  }
}
