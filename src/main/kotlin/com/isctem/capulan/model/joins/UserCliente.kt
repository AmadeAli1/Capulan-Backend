package com.isctem.capulan.model.joins

import com.isctem.capulan.model.actores.Genre
import com.isctem.capulan.model.actores.UserType
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("UserCliente")
data class UserCliente(
    @Column("nome") val nome: String,
    @Column("bi") val bi: String,
    @Column("tipo") val userType: UserType,
    @Column("senha") val senha: String,
    @Column("sexo") val sexo: Genre,
    @Column("id_terminal") val idTerminal: Int,
    @Column("id_usuario") var idUser: Int,
    @Column("email") val email: String,
    @Column("id_cliente") var id: Int = 0,
    @Column("codigo_postal") var codigoPostal: String,
    @Column("cidade") var cidade: String,
)
