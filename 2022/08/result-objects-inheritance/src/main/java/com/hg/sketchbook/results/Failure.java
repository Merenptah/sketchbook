package com.hg.sketchbook.results;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Failure<S, E> extends Result<S, E> {
    private E errorResult;

    @Override
    public Result<S, E> orElse(Consumer<E> consumer) {
        consumer.accept(errorResult);

        return this;
    }

    @Override
    public Result<S, E> onSuccess(Consumer<S> consumer) {
        return this;
    }
}
