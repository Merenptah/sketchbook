package com.hg.sketchbook.nestedDataStructures;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class Order {
  public abstract <T extends Item> List<T> getItems();

  public abstract Person getAddressee();
}
