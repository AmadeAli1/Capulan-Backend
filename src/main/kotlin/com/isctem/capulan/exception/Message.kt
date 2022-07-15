package com.isctem.capulan.exception

import org.springframework.http.HttpStatus


data class Message(
    val field:String,
    val message: String,
    val status: HttpStatus = HttpStatus.BAD_REQUEST
)
