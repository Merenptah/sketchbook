package com.hg.sketchbook.nestedDataStructures.de.toys;

public class OrderDeService {
  public void order(OrderDe order) {
    System.out.println("VAT: " + order.getAddressee().getVat());
    System.out.println("Ordering: " + order);
  }
}
