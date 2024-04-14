package com.example.assignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepository {
    private val retrofit  :Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productService : ProductService = retrofit.create(ProductService::class.java)
    suspend fun getProducts() : ProductResponse{
        return productService.getProducts()
    }
}