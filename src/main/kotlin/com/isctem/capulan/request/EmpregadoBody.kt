package com.isctem.capulan.request

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.User

data class EmpregadoBody(
    val user: User,
    val empregado: Empregado
)
