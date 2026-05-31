package com.example.shop.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.R
import com.example.shop.adapter.CartAdapter
import com.example.shop.data.CartManager
import androidx.appcompat.app.AlertDialog
import com.example.shop.model.Order
import com.example.shop.model.OrderStatus

class CartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CartAdapter
    private lateinit var tvTotal: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvTotal = view.findViewById(R.id.tvTotalPrice)
        recyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        view.findViewById<Button>(R.id.btnCheckout).setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Оформлення замовлення")
                .setMessage("Ваше замовлення на суму ${CartManager.getTotalPrice()} грн прийнято!")
                .setPositiveButton("OK") { _, _ ->
                    val order = Order(
                        id = System.currentTimeMillis().toString(),
                        products = CartManager.getAll().toList(),
                        totalPrice = CartManager.getTotalPrice(),
                        status = OrderStatus.PENDING
                    )
                    CartManager.cartClear()
                    adapter.notifyDataSetChanged()
                    updateTotal()
                }
                .show()
        }

        adapter = CartAdapter(
            products = CartManager.getAll(),
            onRemove = { product ->
                CartManager.remove(product)
                adapter.notifyDataSetChanged()
                updateTotal()
            }
        )
        recyclerView.adapter = adapter
        updateTotal()
    }

    private fun updateTotal() {
        tvTotal.text = "Разом: ${CartManager.getTotalPrice()} грн"
    }
}