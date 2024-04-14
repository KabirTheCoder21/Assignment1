package com.example.assignment

import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}