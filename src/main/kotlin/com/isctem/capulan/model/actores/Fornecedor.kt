package com.isctem.capulan.model.actores

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.validation.constraints.Email

@Table("Fornecedor")
class Fornecedor(
    @Column("nome_empresa") var nome_empresa:String,
    @Column("contacto") val contacto:String,
    @field:Email var email: String,
) {
    @Id @Column("id_fornecedor") val id:Int=0

}