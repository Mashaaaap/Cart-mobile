package com.example.shop.adapter

import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.model.Product
import android.view.LayoutInflater

class CartAdapter (
    private val products: MutableList<Product>,
    private val onRemove: (Product) -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // тут оголошуєш елементи з XML по id
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)
        val btnRemove = itemView.findViewById<ImageButton>(R.id.btnRemove)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = products[position]
        holder.tvName.text = product.name
        holder.tvPrice.text = "${product.price} грн"
        holder.btnRemove.setOnClickListener {
            onRemove(product)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount() = products.size
}