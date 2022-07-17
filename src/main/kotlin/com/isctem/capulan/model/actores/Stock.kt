package com.isctem.capulan.model.actores

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table("Stock")
class Stock(
    @Column("Quantidade") var quantidade:Int,
    @Column("Data_Chegada") var data_chegada:Date,
    @Column("Preco") var preco:Int,
    @Column("id_terminal") var id_terminal:Int,
    @Column("id_fornecedor") var id_fornecedor:Int,
) {
    @Id @Column("id_stock") val id: Int=0

}