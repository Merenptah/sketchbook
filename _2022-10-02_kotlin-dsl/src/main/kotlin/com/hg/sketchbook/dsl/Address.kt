package com.hg.sketchbook.dsl

data class Address(
    val city: String,
    val zipCode: String,
    val street: String,
    val houseNumber: String,
    val addressType: AddressType
)

enum class AddressType {
    MAIN_ADDRESS, COMPANY_ADDRESS
}
