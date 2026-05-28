package com.example.shop.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.example.shop.R
import com.example.shop.model.Product

class ProductAdapter(
    private val products: List<Product>,
    private val onAddToCart: (Product) -> Unit,
    private val onFavorite: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // 1. ViewHolder — описує один елемент списку
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // тут оголошуєш елементи з XML по id
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        val btnAddToCart = itemView.findViewById<Button>(R.id.btnAddToCart)
        val btnFavorite = itemView.findViewById<ImageButton>(R.id.btnFavorite)
        val ivProduct = itemView.findViewById<ImageView>(R.id.ivProduct)
    }

    // 2. onCreateViewHolder — "надуває" XML у View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    // 3. onBindViewHolder — заповнює дані в конкретний елемент
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.tvName.text = product.name
        holder.tvPrice.text = "${product.price} грн"
        holder.btnFavorite.setOnClickListener {
            onFavorite(product)
        }
        holder.btnAddToCart.setOnClickListener {
            onAddToCart(product)
        }

    }

    // 4. getItemCount — кількість елементів
    override fun getItemCount() = products.size
}