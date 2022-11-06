package com.hg.sketchbook.multivalidations;

import lombok.Getter;

import java.util.Set;

@Getter
public class PositiveInteger {
  private final int value;

  private PositiveInteger(int value) {
    this.value = value;
  }

  public static Result<PositiveInteger, Set<ErrorType>> of(int value) {
    return Validations.<PositiveInteger, ErrorType>of(new PositiveInteger(value))
            .ensure(value != 0, ErrorType.VALUE_IS_NOT_ALLOWED_TO_BE_ZERO)
            .ensure(value > 0, ErrorType.VALUE_IS_NOT_POSITIVE)
            .enforce();
  }

  public static PositiveInteger ofOrThrow(int value) {
    return PositiveInteger.of(value)
        .orThrow(e -> new RuntimeException(e.toString()));
  }
}
