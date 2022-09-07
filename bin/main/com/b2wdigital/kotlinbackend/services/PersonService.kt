package com.b2wdigital.kotlinbackend.services

import com.b2wdigital.kotlinbackend.models.Person
import com.b2wdigital.kotlinbackend.models.address
import com.b2wdigital.kotlinbackend.models.person
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import java.lang.Thread.sleep
import kotlin.concurrent.thread

@Service
class PersonService {
    fun buildPerson() : Person {

        val person = person {
            name = "John"
            age = 25
            address {
                street = "Main Street"
                number = 42
                city = "London"
            }
        }

        person.address.city = "teste"

        return person
    }

    fun runCoroutines() = runBlocking {
        repeat(100) {
            launch {
                delay(1000)
                println("Hello World Coroutines")
            }
        }
    }

    fun runThreads() = runBlocking {
        repeat(100_000) {
            thread {
                sleep(1000)
                println("Hello World Threads")
            }
        }
    }

    fun throwExcecaoAew() : String{
        excecaoNaoTratada()
    }

    fun trataExcecaoAew() : String{
        try{
            excecaoNaoTratada()
        }catch(ex: Exception){
            return "ExcecaoTratada"
        }

        return "ExcecaoNãoTratada"
    }

    private fun excecaoNaoTratada() : Nothing{
        throw Exception("AEEE")
    }

    private fun Person.buildInfo(): String{
        return "Cliente ${name} de idade ${age} mora em ${address}"
    }

    private val Person.isUnderage: Boolean
        get() = this.age < 18
}