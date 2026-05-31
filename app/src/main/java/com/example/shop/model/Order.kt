package com.example.shop.model

data class Order(
    val id: String,
    val products: List<Product>,
    val totalPrice: Double,
    var status: OrderStatus
)

enum class OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED
}