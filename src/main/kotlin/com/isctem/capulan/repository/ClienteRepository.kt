package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.joins.UserCliente
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CoroutineCrudRepository<Cliente, Int> {
    @Query("select * from USERCLIENTE where EMAIL=:$1")
    suspend fun findByEmail(email: String): UserCliente?

    @Query("select * from USERCLIENTE")
    suspend fun getAll(): Flow<UserCliente>

    @Query("update CLIENTE set EMAIL=:email, CODIGO_POSTAL=:codigo, CIDADE=:cidade where ID_CLIENTE=:id")
    suspend fun updateCliente(
        @Param("email") email: String,
        @Param("codigo") codigoPostal: String,
        @Param("cidade") cidade: String,
        @Param("id") id: Int
    ):Boolean?

}