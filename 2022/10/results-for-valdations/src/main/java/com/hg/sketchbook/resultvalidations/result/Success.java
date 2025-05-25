package com.hg.sketchbook.resultvalidations.result;

import java.util.List;
import java.util.function.Function;

final class Success<S, E> implements Result<S, E> {
    private final S successResult;

    Success(S successResult) {
        this.successResult = successResult;
    }

    @Override
    public S orThrow(Function<List<E>, RuntimeException> producer) {
        return successResult;
    }

    @Override
    public S orThrow() {
        return successResult;
    }
}
