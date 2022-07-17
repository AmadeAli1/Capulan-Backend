package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.UserType
import com.isctem.capulan.model.joins.UserEmpregado
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EmpregadoRepository : CoroutineCrudRepository<Empregado, Int> {

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from USERFUNCIONARIO where ID_USUARIO=:$1")
    suspend fun findByIdUser(idUser: Int): UserEmpregado?

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from USERFUNCIONARIO")
    suspend fun getAll(): Flow<UserEmpregado>

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("update USUARIO set NOME =:nome,TIPO=:user,SENHA=:senha where ID_USUARIO=:id")
    suspend fun updateEmpregado(@Param("nome")nome:String,@Param("user") userType: UserType,@Param("senha") senha:String,@Param("id") id:Int): Boolean


}