package com.hg.sketchbook.dsl

fun main() {
    val person = person {
        firstName = "Kurt"
        lastName = "Bärchen"
        birthDate = "2010-01-01"
        addresses {
            address {
                city = "Berlin"
                zipCode = "10000"
                street = "Musterstr."
                houseNumber = "12"
            }
        }
    }

    println(person)
}