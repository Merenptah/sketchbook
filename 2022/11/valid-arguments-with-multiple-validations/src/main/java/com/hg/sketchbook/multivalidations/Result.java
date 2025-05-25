package com.hg.sketchbook.multivalidations;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class Result<S, E> {

  public static <S, E> Result<S, E> succeededWith(S successResult) {
    return new Success<>(successResult);
  }

  public static <S, E> Result<S, E> failedWith(E errorResult) {
    return new Failure<>(errorResult);
  }

  public abstract void onSuccessOrElse(Consumer<S> successHandler, Consumer<E> errorHandler);

  public abstract S orThrow(Function<E, RuntimeException> exceptionProducer);
}
