package com.isctem.capulan.request

import com.isctem.capulan.model.actores.Cliente
import com.isctem.capulan.model.actores.User

data class ClienteBody(
    val cliente: Cliente,
    val user: User
)
