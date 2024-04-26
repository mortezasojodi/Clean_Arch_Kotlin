package com.msa.domain.entities

import com.google.gson.annotations.SerializedName

data class ProductEntity (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    )

fun ProductData.toDomain() = ProductEntity(
    id = id,
    title = title,
    price = price,
    description = description,
    category = category,
    image = image
)

data class ProductData(
    @SerializedName("id")    val id: Int,
    @SerializedName("title")   val title: String,
    @SerializedName("price")   val price: Double,
    @SerializedName("description")   val description: String,
    @SerializedName("category")   val category: String,
    @SerializedName("image")   val image: String,
)
