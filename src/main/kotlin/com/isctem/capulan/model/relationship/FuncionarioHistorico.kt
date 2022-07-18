package com.isctem.capulan.model.relationship

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("Funcionario_Historico")
data class FuncionarioHistorico(
    @Column("id_funcionario") val idFuncionario: Int,
    @Column("id_historico") val idHistorico: Int
)
