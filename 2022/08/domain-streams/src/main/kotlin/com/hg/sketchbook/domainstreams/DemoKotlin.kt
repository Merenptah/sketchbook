package com.hg.sketchbook.domainstreams

import java.math.BigDecimal
import java.util.*

fun main() {
    println(
        listOf(Money(BigDecimal(2.12)), Money(BigDecimal(42.12)))
            .multiplyBy(10.0)
            .whichAreBiggerThan(Money(BigDecimal(100.0)))
            .withLeastAmount()
    )
}

fun List<Money>.whichAreBiggerThan(threshold: Money): List<Money> =
    this.filter { it.isBiggerThan(threshold) }

fun List<Money>.multiplyBy(factor: Double): List<Money> =
    this.map { it.scale(factor) }

fun List<Money>.withLeastAmount(): Money? = this.min()


