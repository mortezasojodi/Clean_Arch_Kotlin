package com.msa.domain.entities

data class ProductEntity (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    )