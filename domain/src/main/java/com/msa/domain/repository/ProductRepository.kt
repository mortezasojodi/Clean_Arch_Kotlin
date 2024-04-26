package com.msa.domain.repository

import com.msa.domain.entities.ProductEntity

interface ProductRepository {
    suspend fun getAll(): Result<List<ProductEntity>>
}