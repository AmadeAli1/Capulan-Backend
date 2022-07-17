package com.isctem.capulan

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.Genre
import com.isctem.capulan.model.actores.User
import com.isctem.capulan.model.actores.UserType
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
            val funcionario = Empregado(
                salario = 1234567f,
                jobArea = UserType.ADMIN,
                idUser = 0
            )
            val user = User(
                nome = "Prannay Pablo",
                bi = "1l34s67890123",
                senha = "pranas123",
                userType = UserType.FUNCIONARIO,
                sexo = Genre.MASCULINO,
                idTerminal = 1
            )
            userService.saveEmpregado(user, funcionario)

        }
    }

}

fun main(args: Array<String>) {

    runApplication<CapulanBackendApplication>(*args)
}

