package com.hg.sketchbook.dsl

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDate,
    val addresses: Collection<Address>
)