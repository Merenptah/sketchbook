package com.hg.sketchbook.validarguments;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Success<S, E> extends Result<S, E> {
    private S successResult;

    @Override
    public void onSuccessOrElse(Consumer<S> successHandler, Consumer<E> errorHandler) {
        successHandler.accept(successResult);
    }

    @Override
    public S orThrow(Function<E, RuntimeException> exceptionProducer) {
        return successResult;
    }

    @Override
    public Result<S, E> ensure(Predicate<S> predicate, E error) {
        return predicate.test(successResult)
            ? Result.succeededWith(successResult)
            : Result.failedWith(error);
    }
}
