package com.isctem.capulan.model.joins

import com.isctem.capulan.model.actores.Genre
import com.isctem.capulan.model.actores.UserType
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("UserEmpregado")
data class UserEmpregado(
    @Column("nome") val nome: String,
    @Column("bi") val bi: String,
    @Column("tipo") val userType: UserType,
    @Column("senha") val senha: String,
    @Column("sexo") val sexo: Genre,
    @Column("id_terminal") val idTerminal: Int,
    @Column("salario") val salario: Float,
    @Column("area_trabalho") val jobArea: UserType,
    @Column("id_usuario") var idUser: Int,
    @Column("id_funcionario") var id: Int = 0
)
