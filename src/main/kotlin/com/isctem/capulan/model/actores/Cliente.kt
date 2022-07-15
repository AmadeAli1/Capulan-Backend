package com.isctem.capulan.model.actores

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.validation.constraints.Email

@Table("CLIENTE")
data class Cliente(
    @Id @Column("id_cliente") val id: Int,
    @field:Email var email: String,
    @Column("codigo_postal") var codigoPostal: String,
    var cidade: String,
    @Column("id_usuario") var idUser: Int,

) {
    @org.springframework.data.annotation.Transient
    var user: User? = null
}
