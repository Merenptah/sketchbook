package com.hg.sketchbook.results;

import com.hg.sketchbook.results.errors.Errors.General;

public class Demo {

  public static void main(String[] args) {

    System.out.printf("Starting case 1: Failed result.%n");
    final Result<String> firstCase = Result.fail(General.notFound("dummy", 12313));

    firstCase.onSuccess(s -> {
      System.out.printf("Success: %s", s);
    }).orElse(e -> {
      System.out.printf("Error: %s", e);
    });

    System.out.printf("%n%nStarting case 2: Successful result.%n");
    final Result<String> secondCase = Result.ok("Teststring");

    secondCase.onSuccess(s -> {
      System.out.printf("Success: %s", s);
    }).orElse(e -> {
      System.out.printf("Error: %s", e);
    });
  }
}
