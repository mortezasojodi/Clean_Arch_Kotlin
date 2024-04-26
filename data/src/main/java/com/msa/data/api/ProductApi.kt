package com.msa.data.api

import com.msa.domain.entities.ProductEntity
import retrofit2.http.GET

interface  ProductApi {
    @GET("/products")
suspend fun getProducts() : List<ProductEntity>

}