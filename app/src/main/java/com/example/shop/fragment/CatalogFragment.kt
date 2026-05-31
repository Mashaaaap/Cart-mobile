package com.example.shop.fragment

import android.os.Bundle
import com.example.shop.model.Product
import com.example.shop.adapter.ProductAdapter
import com.example.shop.data.CartManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shop.R
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shop.data.ProductRepository


class CatalogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val products = ProductRepository.allProducts

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        loadProducts()

        adapter = ProductAdapter(
            products = products,
            onAddToCart = { product ->
                CartManager.add(product)
                Toast.makeText(requireContext(), "${product.name} додано в кошик", Toast.LENGTH_SHORT).show()
            },
            onFavorite = { product ->
                product.isFavorite = !product.isFavorite
            }
        )
        recyclerView.adapter = adapter
    }

    private fun loadProducts() {
        ProductRepository.loadProducts()
    }
}