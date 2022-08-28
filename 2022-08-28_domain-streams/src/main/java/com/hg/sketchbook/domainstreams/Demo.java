package com.hg.sketchbook.domainstreams;

import java.math.BigDecimal;
import java.util.List;

public class Demo {

  public static void main(String[] args) {
    MoneyStream.from(List.of(
            new Money(new BigDecimal(2.12)),
            new Money(new BigDecimal(42.12))))
        .multiplyBy(10)
        .whichAreBiggerThan(new Money(new BigDecimal(100.0)))
        .withLeastAmount()
        .ifPresent(m -> System.out.println(m));
  }
}
