package com.hg.sketchbook.resultvalidations.result;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Validations<E> {
  private List<E> validationFailures;

  public Validations() {
    this.validationFailures = Collections.emptyList();
  }

  private Validations(List<E> validationFailures) {
    this.validationFailures = validationFailures;
  }

  public Validations<E> validate(boolean evaluatedCondition, E validationError) {
      if (evaluatedCondition == false) {
        return new Validations<>(Stream.concat(this.validationFailures.stream(), Stream.of(validationError))
            .toList());
      }

      return this;
  }

  public <S> Result<S, E> ifSuccessful(Supplier<S> supplier) {
    if (!validationFailures.isEmpty()) {
      return Result.failedWith(validationFailures);
    }

    return Result.succeededWith(supplier.get());
  }
}
