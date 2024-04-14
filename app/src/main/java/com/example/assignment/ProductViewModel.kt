package com.example.assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val productRepository = ProductRepository()
    private val _productList = MutableLiveData<ProductResponse>()

    val productList : LiveData<ProductResponse>
        get() = _productList

    fun fetchProducts()
    {
        viewModelScope.launch {
            _productList.value = productRepository.getProducts()
        }
    }
}