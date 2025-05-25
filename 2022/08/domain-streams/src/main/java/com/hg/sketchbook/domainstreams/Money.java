package com.hg.sketchbook.domainstreams;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record Money(BigDecimal amount) implements Comparable<Money> {
    public static Money ZERO =
        new Money(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP));

    public Money(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public Money scale(long multiply, long divide) {
        return this.scale(new BigDecimal(multiply), new BigDecimal(divide));
    }

    public Money scale(double factor) {
        BigDecimal newAmount = this.amount.multiply(new BigDecimal(factor));
        return new Money(newAmount);
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount()));
    }

    private Money scale(BigDecimal multiply, BigDecimal divide) {
        return new Money(this.amount.multiply(multiply).divide(divide, 2, RoundingMode.HALF_UP));
    }

    public int compareTo(Money other) {
        return this.amount.compareTo(other.amount);
    }

    public boolean isBiggerThan(Money other) {
        return this.compareTo(other) > 0;
    }

    public String toString() {
        return "$" + this.amount;
    }
}
