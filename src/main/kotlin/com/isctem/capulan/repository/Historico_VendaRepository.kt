package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Historico_Venda
import com.isctem.capulan.model.location.Terminal
import com.isctem.capulan.model.produto.Produto
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface Historico_VendaRepository: CoroutineCrudRepository<Terminal,Int> {
    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("select * from Historico_Vendas where quantidade=:$1")
    suspend fun findByQuantidade(quantidade:Int): Flux<Historico_Venda>

    @Suppress("SpringDataRepositoryMethodReturnTypeInspection")
    @Query("update HISTORICO_VENDAS set QUANTIDADE=:qtd,PRECO=:preco where ID_HISTORICO=:id")
    suspend fun updateHistorico(@Param("qtd")quantidade: Int,@Param("preco")preco:Int,@Param("id")id:Int):Historico_Venda?

}