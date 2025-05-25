package com.hg.sketchbook.nestedDataStructures.fr;

public class OrderFrService {

  public void order(OrderFr order) {
    System.out.println(
        "Departement: " + order.getAddressee().getDeliveryAddress().getDepartement());

    order.getItems().stream()
        .map(ItemFr::getTax)
        .forEach(tax -> System.out.println("Tax: " + tax));

    System.out.println("Ordering: " + order);
  }
}
