package com.isctem.capulan.repository

import com.isctem.capulan.model.location.Terminal
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TerminalRepository : CoroutineCrudRepository<Terminal, Int> {
    @Query("select * from Terminal@laptop1")
    fun find(): Flow<Terminal>
}