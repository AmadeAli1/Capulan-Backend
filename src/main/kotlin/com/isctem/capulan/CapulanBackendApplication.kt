package com.isctem.capulan

import com.isctem.capulan.service.UserService
import kotlinx.coroutines.runBlocking
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CapulanBackendApplication(
    private val userService: UserService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        runBlocking {
            userService.findAllClientes().collect {
                println(it)
            }
            userService.saveCliente()
        }
    }

}

fun main(args: Array<String>) {

    runApplication<CapulanBackendApplication>(*args)
}

