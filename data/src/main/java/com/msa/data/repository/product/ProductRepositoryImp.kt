package com.msa.data.repository.product

import com.msa.data.api.ProductApi
import com.msa.domain.entities.ProductEntity
import com.msa.domain.entities.toDomain
import com.msa.domain.repository.ProductRepository

class ProductRepositoryImp(private val api: ProductApi) : ProductRepository {

   override suspend fun getAll() : Result<List<ProductEntity>> =try {
       val result = api.getProducts();
        Result.success(result.map { it.toDomain()});
   } catch (e: Exception){
        Result.failure(e);
   }

}