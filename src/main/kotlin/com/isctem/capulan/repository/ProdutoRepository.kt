package com.isctem.capulan.repository

import com.isctem.capulan.model.produto.Produto
import org.springframework.data.r2dbc.repository.Modifying
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.concurrent.Flow

@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface ProdutoRepository : CoroutineCrudRepository<Produto, Int> {
    @Query("select * from Produto where Nome=:$1")
    suspend fun findByNome(nome: String): Flux<Produto>

    @Query("select * from Produto where Preco=:$1")
    suspend fun findByPreco(preco: Int): Flux<Produto>

    @Modifying
    @Query("update Produto set Nome=:nome, Preco=:preco,Quantidade_Disponivel=:qtd where id_produto=:id")
    suspend fun updateProduto(
        @Param("nome") nome: String,
        @Param("preco") preco: Int,
        @Param("qtd") quantidade: Int,
        @Param("id") id: Int
    ): Int
}