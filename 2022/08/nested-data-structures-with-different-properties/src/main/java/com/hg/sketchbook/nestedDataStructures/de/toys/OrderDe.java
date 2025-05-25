package com.hg.sketchbook.nestedDataStructures.de.toys;

import com.hg.sketchbook.nestedDataStructures.Item;
import com.hg.sketchbook.nestedDataStructures.Order;
import lombok.ToString;

import java.util.List;

@ToString
public class OrderDe extends Order {

  protected PersonDe addressee;

  private List<Item> items;

  public OrderDe(PersonDe addressee, List<Item> items) {
    this.items = items;
    this.addressee = addressee;
  }

  @Override
  public List<Item> getItems() {
    return items;
  }

  @Override
  public PersonDe getAddressee() {
    return addressee;
  }
}
