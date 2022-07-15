package com.isctem.capulan.service

import com.isctem.capulan.exception.Message
import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.User
import com.isctem.capulan.model.actores.UserType.CLIENTE
import com.isctem.capulan.repository.ClienteRepository
import com.isctem.capulan.repository.EmpregadoRepository
import com.isctem.capulan.repository.UserRepository
import kotlinx.coroutines.flow.map
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.mail.PasswordAuthentication

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
        val user = userRepository.findById(id = codigo)
        return if (user == null) {
            ResponseEntity(Message(field = "codigo", message = "User not found"), HttpStatus.BAD_REQUEST)
        } else if (user.senha == senha) {
            when (user.userType) {
                CLIENTE -> {
                    val cliente = clienteRepository.findByIdUser(idUser = user.id)
                    cliente.user = user
                    ResponseEntity(cliente, HttpStatus.OK)
                }
                else -> {
                    val empregado = empregadoRepository.findByIdUser(idUser = user.id)
                    empregado.user = user
                    ResponseEntity(empregado, HttpStatus.OK)
                }
            }
        } else {
            ResponseEntity(Message(field = "senha", message = "Senha invalida"), HttpStatus.BAD_REQUEST)
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