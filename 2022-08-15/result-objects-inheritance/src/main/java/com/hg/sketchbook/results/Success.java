package com.hg.sketchbook.results;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Success<S, E> extends Result<S, E> {
    private S successResult;

    @Override
    public Result<S, E> orElse(Consumer<E> consumer) {
        return this;
    }

    @Override
    public void onSuccess(Consumer<S> consumer) {
        consumer.accept(successResult);
    }
}
