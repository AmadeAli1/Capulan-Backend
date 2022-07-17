package com.isctem.capulan.repository

import com.isctem.capulan.model.actores.Stock
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository: CoroutineCrudRepository<Stock,Int>{

}