package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Cliente
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository : CoroutineCrudRepository<Cliente, Int> {

    @Query("select * from CLIENTE where ID_USUARIO=:$1")
    suspend fun findByIdUser(idUser: Int): Cliente

}