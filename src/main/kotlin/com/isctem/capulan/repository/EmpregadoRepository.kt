package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.enums.UserType
import com.isctem.capulan.model.joins.UserFuncionario
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface EmpregadoRepository : CoroutineCrudRepository<Empregado, Int> {

    @Query("select * from USERFUNCIONARIO where ID_USUARIO=:$1")
    suspend fun findByIdUser(idUser: Int): UserFuncionario?

    @Query("select * from USERFUNCIONARIO")
    suspend fun getAll(): Flow<UserFuncionario>

    @Modifying
    @Query("update USUARIO set NOME =:nome,TIPO=:user,SENHA=:senha where ID_USUARIO=:id")
    suspend fun updateEmpregado(
        @Param("nome") nome: String,
        @Param("user") userType: UserType,
        @Param("senha") senha: String,
        @Param("id") id: Int
    ): Int


}