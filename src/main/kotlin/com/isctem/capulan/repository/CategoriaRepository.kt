package com.isctem.capulan.repository

import com.isctem.capulan.model.produto.Categoria
import com.isctem.capulan.model.produto.Produto
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CategoriaRepository : CoroutineCrudRepository<Categoria, Int> {

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from CATEGORIA where NOME=:nome")
    suspend fun findByNome(nome: String): Flux<Categoria>

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from Categoria where Tipo=:tipo")
    suspend fun findByTipo(tipo: String): Flux<Categoria>

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("update CATEGORIA set NOME =:nome,TIPO=:tipo where ID_CATEGORIA=:id;")
    suspend fun updateCategoria(@Param("nome") nome: String, @Param("tipo") tipo: String, @Param("id") id: Int): Boolean

}