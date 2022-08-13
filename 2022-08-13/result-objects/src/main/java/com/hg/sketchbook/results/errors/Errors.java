package com.hg.sketchbook.results.errors;

public abstract class Errors {
  public static class Student {
    public static Error emailIsTaken(String email) {
      return new Error(
          Code.STUDENT_EMAIL_IS_TAKEN,
          String.format("Student email '%s' is already taken.", email));
    }

  }

  public static class General {
    public static Error notFound(String entityName, long id) {
      return new Error(
          Code.RECORD_NOT_FOUND,
          String.format("'%s' not found for ID '%s'.", entityName, id));
    }
  }

  public enum Code {
    STUDENT_EMAIL_IS_TAKEN("student.email.isTaken"),
    RECORD_NOT_FOUND("record.notFound");

    private String code;

    Code(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }
}
