package com.isctem.capulan.model.produto

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("Produto")
class Produto(
    @Column("nome") var nome: String,
    @Column("preco") var preco: Int,
    @Column("quantidade_disponivel") var quantidade_disponivel: Int,
    @Column("id_categoria") val idCategoria: Int,
    @Column("id_stock") val idStock: Int
) {
    @Id
    @Column("id_produto")
    val id: Int = 0
}