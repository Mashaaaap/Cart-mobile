package com.example.shop.data

import com.example.shop.model.Product

object CartManager {
    private val items = mutableListOf<Product>()
    fun add(product: Product) {
        items.add(product)
    }

    fun remove(product: Product) {
        items.remove(product)
    }

    fun getAll(): List<Product> {
        return items
    }

    fun getTotalPrice() : Double {
        return items.sumOf{it.price}
    }
}