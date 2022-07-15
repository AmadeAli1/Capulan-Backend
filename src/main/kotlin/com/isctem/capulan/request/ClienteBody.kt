package com.isctem.capulan.request

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.User
import org.springframework.validation.annotation.Validated
import javax.validation.Valid

@Validated
data class ClienteBody(
    @Valid val cliente: Cliente,
    @Valid val user: User
)
