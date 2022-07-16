package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.joins.UserCliente
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CoroutineCrudRepository<Cliente, Int> {
    @Query("select * from USERCLIENTE where EMAIL=:$1")
    suspend fun findByEmail(email: String): UserCliente?

}