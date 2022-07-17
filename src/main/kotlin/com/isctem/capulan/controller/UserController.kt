package com.isctem.capulan.controller

import com.isctem.capulan.exception.Validation
import com.isctem.capulan.request.ClienteBody
import com.isctem.capulan.request.EmpregadoBody
import com.isctem.capulan.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/mz/user")
class UserController(
    private val userService: UserService,
    private val validator: Validation
) {

    @PostMapping("/cliente")
    suspend fun saveCliente(@RequestBody clienteBody: ClienteBody): ResponseEntity<Any> {
        val validateCliente = validator.validateCliente(clienteBody)
        if (validateCliente != null) {
            return validateCliente
        }
        return userService.saveUser(cliente = clienteBody.cliente, user = clienteBody.user)
    }

    @PostMapping("/empregado")
    suspend fun saveEmpregado(@Valid @RequestBody empregadoBody: EmpregadoBody): ResponseEntity<Any> {
        val validateEmpregado = validator.validateEmpregado(empregadoBody)
        if (validateEmpregado != null) {
            return validateEmpregado
        }
        return userService.saveEmpregado(user = empregadoBody.user, empregado = empregadoBody.empregado)
    }

    @GetMapping("/login/work")
    suspend fun login(
        @RequestParam("codigo", required = true) id: Int,
        @RequestParam("senha") senha: String
    ): ResponseEntity<out Any> {
        return userService.login(codigo = id, senha = senha)
    }

    @GetMapping("/login/client")
    suspend fun login(
        @RequestParam("email", required = true) email: String,
        @RequestParam("senha") senha: String
    ): ResponseEntity<out Any> {
        return userService.loginUser(email = email, senha = senha)
    }


    @GetMapping("/cliente")
    suspend fun findClientes() = userService.findAllClientes()

    @GetMapping("/empregado")
    suspend fun findFuncionario() = userService.findAllFuncionarios()


}