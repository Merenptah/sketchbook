package com.hg.sketchbook.results;

import com.hg.sketchbook.results.errors.Error;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Result<T> {
  private final T value;
  private final Error error;

  public static <T> Result<T> ok(T value) {
    return new Result<>(value, null);
  }

  public static <T> Result<T> fail(Error error) {
    return new Result<>(null, error);
  }

  public T orElse(T alternative) {
    return value != null ? value : alternative;
  }

  public Result<T> orElse(Consumer<Error> consumer) {
    if (hasFailed()) {
      consumer.accept(error);
    }

    return this;
  }

  public Result<T> onSuccess(Consumer<T> consumer) {
    if (isOk())
      consumer.accept(value);

    return this;
  }

  public Result<T> onSuccess(Runnable runnable) {
    if (isOk())
      runnable.run();

    return this;
  }

  public <R> Result<R> onSuccess(
      Function<T, Result<R>> map) {
    if (hasFailed())
      return Result.fail(this.error);

    return map.apply(value);
  }
  public <R> Result<R> onSuccessBind(Function<T,R> map) {
    if (hasFailed())
      return Result.fail(this.error);


    return Result.ok(map.apply(value));
  }

  public Result<T> ensure(Predicate<T> predicate, Error error) {
    if (hasFailed())
      return this;

    if (!predicate.test(value)) {
      return Result.fail(error);
    }

    return this;
  }

  public <R> R returning(Function<Result<T>, R> map) {
    return map.apply(this);
  }

  public Boolean hasFailed() {
    return error != null;
  }

  public Boolean isOk() {
    return !hasFailed();
  }

  public T value() {
    return value;
  }

  public Error getError() {
    return error;
  }
}
