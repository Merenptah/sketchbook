package com.hg.sketchbook.validarguments;

import lombok.Getter;

@Getter
public class PositiveInteger {
  private final int value;

  private PositiveInteger(int value) {
    this.value = value;
  }

  public static Result<PositiveInteger, ErrorType> of(int value) {
    final Result<PositiveInteger, ErrorType> result = Result.succeededWith(
        new PositiveInteger(value));

    return result.ensure(p -> p.value > 0, ErrorType.VALUE_IS_NOT_POSITIVE);
  }

  public static PositiveInteger ofOrThrow(int value) {
    return PositiveInteger.of(value)
        .orThrow(e -> new RuntimeException(e.name()));
  }
}
