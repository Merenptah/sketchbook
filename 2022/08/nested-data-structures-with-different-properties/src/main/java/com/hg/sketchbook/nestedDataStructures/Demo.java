package com.hg.sketchbook.nestedDataStructures;

import com.hg.sketchbook.nestedDataStructures.de.toys.AddressDe;
import com.hg.sketchbook.nestedDataStructures.de.toys.OrderDe;
import com.hg.sketchbook.nestedDataStructures.de.toys.OrderDeService;
import com.hg.sketchbook.nestedDataStructures.de.toys.PersonDe;
import com.hg.sketchbook.nestedDataStructures.de.toys.ToyItem;
import com.hg.sketchbook.nestedDataStructures.fr.AddressFr;
import com.hg.sketchbook.nestedDataStructures.fr.ItemFr;
import com.hg.sketchbook.nestedDataStructures.fr.OrderFr;
import com.hg.sketchbook.nestedDataStructures.fr.OrderFrService;
import com.hg.sketchbook.nestedDataStructures.fr.PersonFr;

import java.util.List;

public class Demo {

  public static void main(String[] args) {
    System.out.println("# FR orderFr");
    var orderFr = new OrderFr(
        new PersonFr(new AddressFr("81712", "Côte d'Azur"), "ENF"),
        List.of(new ItemFr("Soap", 3.45, 0.12)));

    new OrderService().order(orderFr);
    new OrderFrService().order(orderFr);

    System.out.println("# DE orderFr");
    var orderDe = new OrderDe(
        new PersonDe(new AddressDe("81712", "Musterstr."), "DE123123"),
        List.of(new ToyItem("Soap", 3.45, "Do not eat.")));

    new OrderService().order(orderDe);
    new OrderDeService().order(orderDe);

  }
}
