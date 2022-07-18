package com.isctem.capulan.model.actores

import com.isctem.capulan.enums.UserType
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("USUARIO")
data class User(
    val nome: String,
    @Length(min = 13, max = 13) val bi: String,
    @Column("tipo") val userType: UserType,
    val senha: String,
    val sexo: Genre,
    @Column("id_terminal") val idTerminal: Int
) {
    @Id
    @Column("id_usuario")
    var id: Int = 0
}
