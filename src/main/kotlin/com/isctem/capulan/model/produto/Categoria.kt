package com.isctem.capulan.model.produto

import com.isctem.capulan.model.location.Region
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("CATEGORIA")
data class Categoria(
    @Column("nome") val name: CategoriaType,
    @Column("tipo") val type: String = Region.MOZAMBIQUE.dressCode
) {
    @Id
    @Column("id_categoria")
    var id: Int = 0
}
