package com.example.assignment

data class Product(
    val title : String,
    val description : String,
    val thumbnail : String
)
data class ProductResponse(
    val products: List<Product>
)
