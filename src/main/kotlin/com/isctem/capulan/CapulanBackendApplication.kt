package com.isctem.capulan

import kotlinx.coroutines.runBlocking
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CapulanBackendApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        runBlocking {

        }
    }
}

fun main(args: Array<String>) {

    runApplication<CapulanBackendApplication>(*args)
}

