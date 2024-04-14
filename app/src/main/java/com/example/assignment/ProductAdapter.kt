package com.example.assignment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.assignment.databinding.ProductItemsBinding

class ProductAdapter(private var productResponse: ProductResponse, private val context: AppCompatActivity) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(private val binding : ProductItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product)
        {
            try {
                Glide.with(context)
                    .load(product.thumbnail)
                    .apply(RequestOptions().centerCrop())
                    .into(binding.imageView)
            }catch (e : Exception){
                Toast.makeText(context, "${e.message}", Toast.LENGTH_SHORT).show()
            }
            binding.title.text = product.title
            binding.description.text = product.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productResponse.products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productResponse.products[position]
        holder.bind(product)
    }

    fun updateList(newResponse: ProductResponse) {
        productResponse = newResponse
        notifyDataSetChanged()
    }
}