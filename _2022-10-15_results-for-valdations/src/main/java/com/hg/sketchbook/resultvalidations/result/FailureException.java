package com.hg.sketchbook.resultvalidations.result;

/**
 * This should not be thrown anywhere but in a Failure. It signifies a developer error and is only
 * public to allow the failure capture layer of your application to translate it into an
 * "internal error", e.g. an InternalServerError for an application with REST interface.
 */
public class FailureException extends RuntimeException {
  public FailureException(String message) {
    super(message);
  }
}
