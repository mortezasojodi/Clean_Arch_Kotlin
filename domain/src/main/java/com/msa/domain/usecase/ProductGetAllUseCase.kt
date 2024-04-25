package com.msa.domain.usecase

import com.msa.domain.entities.ProductEntity
import com.msa.domain.repository.ProductRepository

class ProductGetAllUseCase(private val repository: ProductRepository) {
     suspend fun getAll(): Result<ProductEntity> = repository.getAll();

}