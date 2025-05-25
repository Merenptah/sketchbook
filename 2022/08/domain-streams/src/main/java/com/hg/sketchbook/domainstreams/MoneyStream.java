package com.hg.sketchbook.domainstreams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MoneyStream implements ForwardingStream<Money> {
    private Stream<Money> stream;

    private MoneyStream(Stream<Money> stream) {
        this.stream = stream;
    }

    @Override
    public Stream<Money> getStream() { return this.stream; }


    public static MoneyStream from(List<Money> painters) {
        return new MoneyStream(painters.stream());
    }

    public MoneyStream whichAreBiggerThan(Money threshold) {
        return new MoneyStream(this.getStream().filter(m -> m.isBiggerThan(threshold)));
    }

    public MoneyStream multiplyBy(double multiplicator) {
        return new MoneyStream(this.getStream().map(m -> m.scale(multiplicator)));
    }

    public Optional<Money> withLeastAmount() {
        return this.getStream().min(Money::compareTo);
    }
}
