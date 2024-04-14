package com.example.assignment

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var productViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        productAdapter = ProductAdapter(ProductResponse(emptyList()),this)
        binding.recyclerViewProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = productAdapter
        }

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel.productList.observe(this) {
            productAdapter.updateList(it)
            productAdapter.notifyDataSetChanged()
        }

        productViewModel.fetchProducts()
    }
}