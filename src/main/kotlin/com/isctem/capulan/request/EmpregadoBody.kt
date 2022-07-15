package com.isctem.capulan.request

import com.isctem.capulan.model.actores.Empregado
import com.isctem.capulan.model.actores.User
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
data class EmpregadoBody(
    @Valid val user: User,
    @Valid val empregado: Empregado
)
