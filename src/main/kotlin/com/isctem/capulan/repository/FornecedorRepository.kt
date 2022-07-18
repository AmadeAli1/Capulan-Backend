package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Fornecedor
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface FornecedorRepository : CoroutineCrudRepository<Fornecedor, Int> {

    @Query("select * from Fornecedor where EMAIL=:email")
    suspend fun findByEmail(email: String): Fornecedor?

    @Query("select * from Fornecedor where NOME_EMPRESA=:nome")
    suspend fun findByCompanyName(nome: String): Fornecedor?

    @Modifying
    @Query("update FORNECEDOR set NOME_EMPRESA=:nome,CONTACTO=:contacto,EMAIL=:email where ID_FORNECEDOR=:id")
    suspend fun updateFornecedor(
        @Param("nome") nome: String?,
        @Param("contacto") contacto: String?,
        @Param("email") email: String?,
        @Param("id") id: Int
    ): Int

}