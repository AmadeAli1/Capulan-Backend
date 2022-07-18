package com.isctem.capulan.model.relationship

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("Funcionario_Encomenda")
data class FuncionarioEncomenda(
    @Column("id_funcionario") val idFuncionario: Int,
    @Column("id_encomenda") val idEncomenda: Int
)
