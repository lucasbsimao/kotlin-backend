package com.b2wdigital.kotlinbackend.controllers

import com.b2wdigital.kotlinbackend.models.Person
import com.b2wdigital.kotlinbackend.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController{

    @Autowired
    lateinit var personService : PersonService

    @GetMapping(value=["/person"])
    fun buildPerson() : Person = personService.buildPerson()

    @GetMapping(value=["/throwerror"])
    fun runThrow() = personService.throwExcecaoAew()

    @GetMapping(value=["/tratarerror"])
    fun runTratamento() = personService.trataExcecaoAew()

    @GetMapping(value=["/coroutine"])
    fun runCoroutine() = personService.runCoroutines()

    @GetMapping(value=["/thread"])
    fun runThreads() = personService.runThreads()

}