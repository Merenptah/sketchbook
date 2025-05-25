package com.hg.sketchbook.validarguments;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Failure<S, E> extends Result<S, E> {
    private E errorResult;

    @Override
    public void onSuccessOrElse(Consumer<S> successHandler, Consumer<E> errorHandler) {
        errorHandler.accept(errorResult);
    }

    @Override
    public S orThrow(Function<E, RuntimeException> exceptionProducer) {
        throw exceptionProducer.apply(errorResult);
    }
    @Override
    public Result<S, E> ensure(Predicate<S> predicate, E error) {
        return this;
    }
}
