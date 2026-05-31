package com.example.shop.data

import com.example.shop.model.Order
import com.example.shop.model.OrderStatus

object OrderManager {
    private val orders = mutableListOf<Order>()

    fun placeOrder(order: Order) {
        orders.add(order)
    }

    fun getOrders(): List<Order> {
        return orders
    }
}