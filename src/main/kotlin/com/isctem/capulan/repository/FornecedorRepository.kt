package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Fornecedor
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface FornecedorRepository : CoroutineCrudRepository<Fornecedor, Int> {
    //    @Query("")
    @Query("select * from Fornecedor where EMAIL=:email")
    fun findByEmail(email: String): Fornecedor?

    @Query("select * from Fornecedor where NOME_EMPRESA=:nome")
    fun findByCompanyName(nome: String): Fornecedor?

    @Query("update FORNECEDOR set NOME_EMPRESA=:nome,CONTACTO=:contacto,EMAIL=:email where ID_FORNECEDOR=:id")
    fun updateFornecedor(
        @Param("nome") nome: String?,
        @Param("contacto") contacto: String?,
        @Param("email") email: String?,
        @Param("id") id: Int
    ): Boolean?

}