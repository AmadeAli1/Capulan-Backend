package com.isctem.capulan.controller

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.request.ClienteBody
import com.isctem.capulan.request.EmpregadoBody
import com.isctem.capulan.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/mz/user")
class UserController(private val userService: UserService) {

    @PostMapping("/cliente")
    suspend fun saveCliente(@Valid @RequestBody clienteBody: ClienteBody): ResponseEntity<Any> {
        return userService.saveUser(cliente = clienteBody.cliente, user = clienteBody.user)
    }

    @PostMapping("/empregado")
    suspend fun saveEmpregado(@Valid @RequestBody empregadoBody: EmpregadoBody): ResponseEntity<Empregado> {
        return userService.saveEmpregado(user = empregadoBody.user, empregado = empregadoBody.empregado)
    }

    @GetMapping("/cliente")
    suspend fun findClientes() = userService.findAllClientes()

    @GetMapping("/empregado")
    suspend fun findFuncionario() = userService.findAllFuncionarios()


}