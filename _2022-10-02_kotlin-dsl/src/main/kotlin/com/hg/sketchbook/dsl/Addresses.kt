package com.hg.sketchbook.dsl

class Addresses : ArrayList<Address>() {
    fun address(addressBuilder: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(addressBuilder).build())
    }
}