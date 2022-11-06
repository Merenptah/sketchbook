package com.hg.sketchbook.multivalidations;

public class Demo {

  public static void main(String[] args) {

    // To be used when called outside of domain, where you do not know if you have valid values
    PositiveInteger.of(-10)
        .onSuccessOrElse(p -> System.out.println("Success: " + MathFunctions.sqrt(p)),
            e -> System.out.println("Fail: " + e));

    PositiveInteger.of(0)
        .onSuccessOrElse(p -> System.out.println("Success: " + MathFunctions.sqrt(p)),
            e -> System.out.println("Fail: " + e));

    PositiveInteger.of(9)
        .onSuccessOrElse(p -> System.out.println("Success: " + MathFunctions.sqrt(p)),
            e -> System.out.println("Fail: " + e));

    // To be used in domain, when you know you have valid values, and only a developer somehow
    // introduces a bug
    System.out.println("Success: " + MathFunctions.sqrt(PositiveInteger.ofOrThrow(10)));

    try {
      System.out.println("Success: " + MathFunctions.sqrt(PositiveInteger.ofOrThrow(-10)));
    } catch (Throwable e) {
      System.out.println("Fail: " + e.getMessage());
    }
  }
}
