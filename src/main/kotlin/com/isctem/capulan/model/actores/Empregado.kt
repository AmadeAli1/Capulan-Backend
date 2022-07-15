package com.isctem.capulan.model.actores

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.validation.constraints.Min

@Table("Funcionario")
data class Empregado(
    @Min(value = 500) val salario: Float,
    @Column("area_trabalho") val jobArea: JobArea,
    @Column("id_usuario") var idUser: Int,

) {
    @Id
    @Column("id_funcionario")
    var id: Int = 0

    @org.springframework.data.annotation.Transient
    var user: User? = null
}
