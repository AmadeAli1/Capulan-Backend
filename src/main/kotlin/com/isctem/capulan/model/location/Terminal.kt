package com.isctem.capulan.model.location

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("Terminal")
data class Terminal(
    val nome: String,
    val regiao: Region
) {
    @Id
    @Column("id_terminal")
    var id: Int = 0
}
