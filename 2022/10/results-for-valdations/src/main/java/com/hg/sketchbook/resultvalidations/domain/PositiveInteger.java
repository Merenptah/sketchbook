package com.hg.sketchbook.resultvalidations.domain;

import static com.hg.sketchbook.resultvalidations.domain.PositiveInteger.ValidationError.*;

import com.hg.sketchbook.resultvalidations.result.Result;
import com.hg.sketchbook.resultvalidations.result.Validations;

public class PositiveInteger {
  private final Integer value;

  private PositiveInteger(Integer value) {
    this.value = value;
  }

  public static Result<PositiveInteger, ValidationError> of(Integer value) {
    return new Validations<ValidationError>()
        .validate(value != null, IS_NOT_ALLOWED_TO_BE_NULL)
        .validate(value != null && value > 0, HAS_TO_BE_POSITIVE)
        .ifSuccessful(() -> new PositiveInteger(value));
  }

  public Integer value() {
    return value;
  }

  @Override
  public String toString() {
    return "PositiveInteger{" +
        "value=" + value +
        '}';
  }

  public enum ValidationError {
    IS_NOT_ALLOWED_TO_BE_NULL,
    HAS_TO_BE_POSITIVE
  }

}

