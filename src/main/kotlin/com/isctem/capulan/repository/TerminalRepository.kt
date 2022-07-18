package com.isctem.capulan.repository

import com.isctem.capulan.model.location.Terminal
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface TerminalRepository : CoroutineCrudRepository<Terminal, Int>