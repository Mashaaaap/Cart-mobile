package com.example.shop.data

import com.example.shop.model.Product

object ProductRepository {
    val allProducts = mutableListOf<Product>()

    fun loadProducts() {
        if (allProducts.isNotEmpty()) return  // не завантажувати двічі

        allProducts.add(Product(
            id = "1",
            name = "Навушники Sony",
            description = "Бездротові навушники",
            price = 1999.99,
            images = null
        ))
        allProducts.add(Product(
            id = "2",
            name = "Ноутбук Lenovo LOQ 15ARP9",
            description = "15.6\" IPS 144 Гц / AMD Ryzen 5 7235HS / RAM 16 ГБ / SSD 512 ГБ / RTX 3050",
            price = 39999.99,
            images = null
        ))
        allProducts.add(Product(
            id = "3",
            name = "Фотокамера Sony ZV-1 Black",
            description = "ЖК-екран зі змінним кутом нахилу для зручної зйомки селфі.",
            price = 25799.00,
            images = null
        ))
    }
}