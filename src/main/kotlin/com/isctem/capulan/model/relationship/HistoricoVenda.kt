package com.isctem.capulan.model.relationship

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table("Historico_vendas")
class HistoricoVenda(
    @Column("quantidade") var quantidade:Int,
    @Column("data_venda") var data_venda:Date,
    @Column("preco") var preco:Int,
    @Column("id_produto") var id_produto:Int,
) {
    @Id
    @Column("id_historico")
    val id:Int=0
}