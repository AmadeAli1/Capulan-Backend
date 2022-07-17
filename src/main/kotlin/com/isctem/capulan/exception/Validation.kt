package com.isctem.capulan.exception

import com.isctem.capulan.request.ClienteBody
import com.isctem.capulan.request.EmpregadoBody
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import javax.validation.Validator

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class Validation(
    private val validator: Validator,
) {

    fun <T> validateRequest(request: T): ResponseEntity<Any>? {
        val validate = validator.validate(request)
        if (validate.isNotEmpty()) {
            val erros = validate.map {
                Message(field = it.propertyPath.toString(), message = it.message)
            }.toList()
            return ResponseEntity(erros, HttpStatus.BAD_REQUEST)
        }
        return null
    }

    fun validateCliente(cliente: ClienteBody): ResponseEntity<Any>? {
        val validate = validator.validate(cliente.cliente)
        val validateUser = validator.validate(cliente.user)

        if (validate.isNotEmpty().or(validateUser.isNotEmpty())) {
            val clienteError = validate.map {
                Message(field = it.propertyPath.toString(), message = it.message)
            }.toList()

            val userError = validateUser.map {
                Message(field = it.propertyPath.toString(), message = it.message)
            }.toList()

            val erros = clienteError+userError
            println(erros)

            return ResponseEntity(erros, HttpStatus.BAD_REQUEST)
        }
        return null
    }

    fun validateEmpregado(empregado: EmpregadoBody): ResponseEntity<Any>? {
        val validateEmpregado = validator.validate(empregado.empregado)
        val validateUser = validator.validate(empregado.user)

        if (validateEmpregado.isNotEmpty().or(validateUser.isNotEmpty())) {
            val empregadoError = validateEmpregado.map {
                Message(field = it.propertyPath.toString(), message = it.message)
            }.toList()

            val userError = validateUser.map {
                Message(field = it.propertyPath.toString(), message = it.message)
            }.toList()

            val erros = empregadoError + userError

            return ResponseEntity(erros, HttpStatus.BAD_REQUEST)
        }
        return null
    }

}
