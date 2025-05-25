package com.hg.sketchbook.results.errors;

import com.hg.sketchbook.results.errors.Errors.Code;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Error {
  private Code code;
  private String message;

  @Override
  public String toString() {
    return code.getCode() + ": " + message;
  }
}
