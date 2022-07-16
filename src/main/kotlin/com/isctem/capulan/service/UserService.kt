package com.isctem.capulan.service

import com.isctem.capulan.exception.Message
import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.User
import com.isctem.capulan.repository.ClienteRepository
import com.isctem.capulan.repository.EmpregadoRepository
import com.isctem.capulan.repository.UserRepository
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val clienteRepository: ClienteRepository,
    private val empregadoRepository: EmpregadoRepository
) {
    /**
     * @author Amade Ali
     * @param user Insercao dos dados do Cliente :: Cadastro
     */
    suspend fun saveUser(user: User, cliente: Cliente): ResponseEntity<Any> {
        if (validarEmail(cliente.email)) {
            return ResponseEntity("Este email ja existe!", HttpStatus.BAD_REQUEST)
        }
        val userCliente = userRepository.save(entity = user)
        cliente.idUser = userCliente.id
        return clienteRepository.save(cliente).run {
            this.user = userCliente
            ResponseEntity(this, HttpStatus.CREATED)
        }
    }

    /**
     * @author Amade Ali
     * @param user Insercao dos dados do Trabalhador :: Cadastro
     */
    suspend fun saveEmpregado(user: User, empregado: Empregado): ResponseEntity<Any> {
        val userCliente = userRepository.save(entity = user)
        empregado.idUser = userCliente.id
        return empregadoRepository.save(empregado).run {
            this.user = userCliente
            ResponseEntity(this, HttpStatus.CREATED)
        }
    }

    /**
     * @author Amade Ali
     * <p>Faz o login do usuario na plataforma</p>
     * @param codigo codigo unico do usuario
     * @param senha senha do usuario para ter acesso
     */
    suspend fun login(codigo: Int, senha: String): ResponseEntity<out Any> {
        val empregado = empregadoRepository.findByIdUser(idUser = codigo)
        return if (empregado == null) {
            ResponseEntity(Message(field = "codigo", message = "Funcionario not found"), HttpStatus.BAD_REQUEST)
        } else if (empregado.senha == senha) {
            ResponseEntity(empregado, HttpStatus.OK)
        } else {
            ResponseEntity(Message(field = "senha", message = "Senha invalida"), HttpStatus.BAD_REQUEST)
        }
    }

    /**
     * @author Amade Ali
     * <p>Faz o login do cliente para visualizar produtos</p>
     * @param codigo codigo unico do cliente
     * @param senha senha do cliente para ter acesso
     */
    suspend fun loginUser(email: String, senha: String): ResponseEntity<out Any> {
        val cliente = clienteRepository.findByEmail(email = email)
        return if (cliente == null) {
            ResponseEntity(Message(field = "email", message = "Email not found"), HttpStatus.BAD_REQUEST)
        } else {
            if (cliente.senha == senha) {
                ResponseEntity(cliente, HttpStatus.OK)
            } else {
                ResponseEntity(Message(field = "senha", message = "Senha invalida"), HttpStatus.BAD_REQUEST)
            }
        }
    }


    /**
     * @author Amade Ali
     * <p>Verificacao da existencia do email</p>
     * @param email email do cliente que sera instroduzido no sistema
     */
    private suspend fun validarEmail(email: String): Boolean {
        return userRepository.existsByEmail(email) != null
    }

    /**
     * @author Amade Ali
     * <p>Encontrar todos os clientes da Regiao de Mozambique</p>
     */
    suspend fun findAllClientes() = clienteRepository.findAll().map {
        it.user = userRepository.findById(it.idUser)
        it
    }

    /**
     * @author Amade Ali
     * <p>Encontrar todos os funcionarios da Regiao de Mozambique</p>
     */
    suspend fun findAllFuncionarios() = empregadoRepository.findAll().map {
        it.user = userRepository.findById(it.idUser)
        it
    }

}