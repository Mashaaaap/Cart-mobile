package com.example.shop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.model.Order
import com.example.shop.model.OrderStatus

class OrderAdapter(
    private val orders: List<Order>
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvOrderId = itemView.findViewById<TextView>(R.id.tvOrderId)
        val tvOrderTotal = itemView.findViewById<TextView>(R.id.tvOrderTotal)
        val tvOrderStatus = itemView.findViewById<TextView>(R.id.tvOrderStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.tvOrderId.text = "Замовлення #${order.id}"
        holder.tvOrderTotal.text = "Сума: ${order.totalPrice} грн"
        holder.tvOrderStatus.text = "Статус: ${getStatusText(order.status)}"
    }

    override fun getItemCount() = orders.size

    private fun getStatusText(status: OrderStatus): String {
        return when (status) {
            OrderStatus.PENDING -> "Очікує"
            OrderStatus.PROCESSING -> "Обробляється"
            OrderStatus.SHIPPED -> "Відправлено"
            OrderStatus.DELIVERED -> "Доставлено"
        }
    }
}