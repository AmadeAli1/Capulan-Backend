package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Encomenda
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
@Suppress("SpringDataRepositoryMethodReturnTypeInspection")
@Repository
interface EncomendaRepository : CoroutineCrudRepository<Encomenda, Int>