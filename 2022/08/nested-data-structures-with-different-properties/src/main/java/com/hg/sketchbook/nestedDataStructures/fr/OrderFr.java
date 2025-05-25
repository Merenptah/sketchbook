package com.hg.sketchbook.nestedDataStructures.fr;

import com.hg.sketchbook.nestedDataStructures.Order;
import lombok.ToString;

import java.util.List;

@ToString
public class OrderFr extends Order {
  protected PersonFr addressee;
  private List<ItemFr> items;

  public OrderFr(PersonFr addressee, List<ItemFr> items) {
    this.items = items;
    this.addressee = addressee;
  }

  @Override
  public List<ItemFr> getItems() {
    return items;
  }

  @Override
  public PersonFr getAddressee() {
    return addressee;
  }
}
