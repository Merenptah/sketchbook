package com.hg.sketchbook.results;

public class Demo {

  public static void main(String[] args) {

    System.out.printf("*** Starting case 1: Failed result.%n");
    final Result<String, ErrorType> firstCase = Result.failedWith(ErrorType.SOMETHING_WENT_WRONG);

    firstCase.onSuccess(s -> {
      System.out.printf("Success: %s", s);
    }).orElse(e -> {
      System.out.printf("Error: %s", e);
    });

    System.out.printf("%n%n*** Starting case 2: Successful result.%n");
    final Result<String, ErrorType> secondCase = Result.succeededWith("Teststring");

    secondCase.onSuccess(s -> {
      System.out.printf("Success: %s", s);
    }).orElse(e -> {
      System.out.printf("Error: %s", e);
    });
  }
}
