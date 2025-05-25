package com.hg.sketchbook.multivalidations;

import java.util.HashSet;
import java.util.Set;

public class Validations<S, E> {
    private final S value;

    private final Set<E> validationErrors = new HashSet<>();


    private Validations(S value) {
        this.value = value;
    }

    public static <S, E> Validations<S, E> of(S value) {
        return new Validations<>(value);
    }

    public Validations<S, E> ensure(boolean evaluatedCondition, E error) {
        if (evaluatedCondition) {
            return this;
        }

        validationErrors.add(error);

        return this;
    }

    public Result<S, Set<E>> enforce() {
        if (validationErrors.isEmpty()) {
            return Result.succeededWith(value);
        }

        return Result.failedWith(validationErrors);
    }
}
