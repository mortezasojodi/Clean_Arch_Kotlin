package com.msa.data.repository.product

import com.msa.data.api.ProductApi
import com.msa.domain.entities.ProductEntity
import com.msa.domain.repository.ProductRepository

class ProductRepositoryImp(val api: ProductApi) : ProductRepository {

   override suspend fun getAll() : Result<ProductEntity> {

    }

}