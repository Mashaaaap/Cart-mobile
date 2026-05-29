package com.example.shop.model

data class Product (
    var id: String,
    var name: String,
    var description: String,
    var price: Double,
    var images: List<String>?,
    var isFavorite: Boolean = false
)