package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.joins.UserEmpregado
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpregadoRepository : CoroutineCrudRepository<Empregado, Int> {


    @Query("select * from USEREMPREGADO where ID_USUARIO=:$1")
    suspend fun findByIdUser(idUser: Int): UserEmpregado?


}