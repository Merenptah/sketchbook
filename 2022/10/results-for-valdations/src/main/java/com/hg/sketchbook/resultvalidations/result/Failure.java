package com.hg.sketchbook.resultvalidations.result;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

final class Failure<S, E> implements Result<S, E> {
    private final List<E> errorResult;

    Failure(List<E> errorResult) {
        this.errorResult = errorResult;
    }

    @Override
    public S orThrow(Function<List<E>, RuntimeException> producer) {
        throw producer.apply(errorResult);
    }

    @Override
    public S orThrow() {
        throw new FailureException(errorResult.stream()
            .map(E::toString)
            .collect(Collectors.joining(", ")));
    }
}
