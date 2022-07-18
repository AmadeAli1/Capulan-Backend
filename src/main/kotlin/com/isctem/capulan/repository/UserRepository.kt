package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.User
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface UserRepository : CoroutineCrudRepository<User, Int> {

    @Query("select * from CLIENTE where EMAIL=:$1")
    suspend fun existsByEmail(email: String): Cliente?

    @Query("select * from USUARIO where bi=:$1")
    suspend fun existsByBi(bi: String): User?

}
