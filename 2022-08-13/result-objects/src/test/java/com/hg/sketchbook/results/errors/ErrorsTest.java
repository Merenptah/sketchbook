package com.hg.sketchbook.results.errors;

import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ErrorsTest {

  @Test
  public void error_codes_must_be_unique () {
    final List<Method> methods = Arrays.stream(Errors.class.getDeclaredClasses())
        .flatMap(c -> Arrays.stream(c.getDeclaredMethods()))
        .filter(m -> m.getReturnType().equals(java.lang.Error.class))
        .collect(Collectors.toList());

    final long numberOfUniqueCodes = methods.stream()
        .map(m -> getErrorCode(m))
        .distinct()
        .count();

    Assertions.assertThat(numberOfUniqueCodes).isEqualTo(methods.size());
  }

  @SneakyThrows
  private String getErrorCode(Method m) {
    final List<Object> args = Arrays.stream(m.getParameters()).map(
        parameter -> {
          if (parameter.getType().equals(String.class)) {
            return "";
          }
          if (parameter.getType().equals(long.class)) {
            return 0;
          }
          throw new RuntimeException("Missing default value mapping for parameter type " + parameter
              .getType());
        }
    ).collect(Collectors.toList());

    final Error invokedError = (Error) m.invoke(null, args.toArray());

    return invokedError.getCode().getCode();
  }
}
