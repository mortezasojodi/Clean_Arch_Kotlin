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

data class MovieData(
    @SerializedName("id") val id: Int,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("category") val category: String,
)
