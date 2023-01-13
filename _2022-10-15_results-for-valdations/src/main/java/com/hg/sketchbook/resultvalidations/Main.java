package com.hg.sketchbook.resultvalidations;

import com.hg.sketchbook.resultvalidations.domain.PositiveInteger;
import com.hg.sketchbook.resultvalidations.result.FailureException;

public class Main {

  public static void main(String[] args) {
    System.out.println(PositiveInteger.of(1).orThrow());
    System.out.println(PositiveInteger.of(10000).orThrow());

    try {
      PositiveInteger.of(0).orThrow();
    } catch (FailureException e) {
      System.out.println(e.getMessage());
    }

    try {
      PositiveInteger.of(null).orThrow();
    } catch (FailureException e) {
      System.out.println(e.getMessage());
    }

  }
}
