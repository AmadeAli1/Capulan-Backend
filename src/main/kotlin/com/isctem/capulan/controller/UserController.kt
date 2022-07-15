package com.isctem.capulan.controller

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.User
import com.isctem.capulan.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/mz/user")
class UserController(private val userService: UserService) {

    @PostMapping("/cliente")
    suspend fun saveCliente(@RequestBody user: User, @RequestBody cliente: Cliente): ResponseEntity<Any> {
        return userService.saveUser(user, cliente)
    }

    @PostMapping("/empregado")
    suspend fun saveEmpregado(@RequestBody user: User, @RequestBody empregado: Empregado): ResponseEntity<Empregado> {
        return userService.saveEmpregado(user, empregado)
    }

    @GetMapping("/cliente")
    suspend fun findClientes() = userService.findAllClientes()

    @GetMapping("/empregado")
    suspend fun findFuncionario() = userService.findAllFuncionarios()

}