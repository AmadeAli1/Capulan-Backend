package com.isctem.capulan.model.relationship

import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("CLiente_Historico")
data class ClienteHistorico(
    @Column("id_cliente") val idCliente: Int,
    @Column("id_historico") val idHistorico: Int
)
