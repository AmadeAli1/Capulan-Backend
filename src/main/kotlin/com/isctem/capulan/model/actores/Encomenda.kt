package com.isctem.capulan.model.actores

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date

@Table("Encomenda")
class Encomenda(
    @Column("Data_entrega") var data_entrega:Date,
    @Column("Quantidade") var quantidade:Int,
    @Column("preco") var preco:Int,
    @Column("estado") var estado:String,
    @Column("id_usuario") var id_usuario:Int,
    @Column("id_produto") var id_produto:Int,
    @Column("id_terminal") var id_terminal:Int,
){
    @Id @Column ("id_encomenda") val id: Int=0
}