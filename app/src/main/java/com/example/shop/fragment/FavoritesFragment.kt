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


class FavoritesFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val favorites = ProductRepository.allProducts.filter { it.isFavorite }

        adapter = ProductAdapter(
            products = favorites,
            onAddToCart = { product ->
                CartManager.add(product)
            },
            onFavorite = { product ->
                product.isFavorite = !product.isFavorite
                adapter.notifyDataSetChanged()
            }
        )
        recyclerView.adapter = adapter
    }
}