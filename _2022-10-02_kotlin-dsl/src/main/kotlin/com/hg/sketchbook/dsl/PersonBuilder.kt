package com.hg.sketchbook.dsl

import java.time.LocalDate

class PersonBuilder {
    var firstName: String = "Max"
    var lastName: String = "Mustermann"
    var birthDate: String = "2000-01-01"
    private val addresses = mutableListOf<Address>()

    fun addresses(addressList: Addresses.() -> Unit) {
        addresses.addAll(Addresses().apply(addressList))
    }

    fun build(): Person = Person(firstName, lastName, LocalDate.parse(birthDate), addresses)
}

fun person(personBuilder: PersonBuilder.() -> Unit) = PersonBuilder().apply(personBuilder).build()