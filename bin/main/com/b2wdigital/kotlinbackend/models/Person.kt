package com.b2wdigital.kotlinbackend.models

data class Person(var name: String? = "",
                  var age: Int = 0,
                  var address: Address = Address())

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.address(block: Address.() -> Unit) {
    address = Address().apply(block)
}
