package com.hg.sketchbook.dsl

class AddressBuilder {
    var zipCode: String = ""
    var city: String = ""
    var houseNumber: String = ""
    var street: String = ""
    var addressType: AddressType = AddressType.MAIN_ADDRESS

    fun build() = Address(city, zipCode, street, houseNumber, addressType)
}