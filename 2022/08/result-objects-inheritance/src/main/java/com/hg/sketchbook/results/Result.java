package com.hg.sketchbook.results;

import java.util.function.Consumer;

abstract class Result<S, E> {
  public static <S, E> Result<S, E> succeededWith(S successResult) {
    return new Success<>(successResult);
  }

  public static <S, E> Result<S, E> failedWith(E errorResult) {
    return new Failure<>(errorResult);
  }

  public abstract Result<S, E> orElse(Consumer<E> consumer);

  public abstract Result<S, E> onSuccess(Consumer<S> consumer);
}
