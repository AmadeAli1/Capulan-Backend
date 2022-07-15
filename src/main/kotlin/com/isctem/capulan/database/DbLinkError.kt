package com.isctem.capulan.database

import com.isctem.capulan.model.location.Region

data class DbLinkError(
    val message: String,
    val region:Region,
)