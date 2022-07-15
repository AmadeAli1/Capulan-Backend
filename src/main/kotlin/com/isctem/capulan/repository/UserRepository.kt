package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.User
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CoroutineCrudRepository<User, Int> {

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from CLIENTE where exists(select * from CLIENTE where EMAIL=:$1) ")
    suspend fun existsByEmail(email: String): Boolean

}
