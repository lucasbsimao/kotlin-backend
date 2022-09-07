package com.b2wdigital.kotlinbackend

import com.mongodb.MongoClientOptions
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class Application{
    @Bean
    fun restTemplate() : RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun mongoOptions() : MongoClientOptions {
        return MongoClientOptions.builder()
            .minConnectionsPerHost(1)
            .connectionsPerHost(200)
            .build()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

