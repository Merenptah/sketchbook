package com.hg.sketchbook.resultvalidations.result;

import java.util.List;
import java.util.function.Function;

public sealed interface Result<S, E> permits Success, Failure {

  static <S, E> Result<S, E> succeededWith(S successResult) {
    return new Success<>(successResult);
  }

  static <S, E> Result<S, E> failedWith(List<E> failureResults) {
    return new Failure<>(failureResults);
  }

  /**
   * Use this if you don't know already, that the result is successful, for example
   * when trying to create a domain object out of input values from a user.
   * You can then produce an exception that is specific for the layer you are in,
   * e.g. a BadRequestException in the API layer of a REST interface.
   */
  S orThrow(Function<List<E>, RuntimeException> producer);

  /**
   * Use this if you are in your domain layer and you "know" that the result will be successful.
   * If it fails anyway, if will throw a FailureException, which is a bug (in contrast to a
   * failure in the other orThrow method).
   */
  S orThrow();
}
