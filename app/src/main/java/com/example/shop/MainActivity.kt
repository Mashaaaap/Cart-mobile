package com.example.shop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.shop.model.Product
import com.example.shop.adapter.ProductAdapter
import com.example.shop.data.CartManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    // 1. Оголошуєш змінні
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val products = mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 2. Ініціалізуєш RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 3. Додаєш тестові товари
        loadProducts()

        // 4. Підключаєш адаптер
        adapter = ProductAdapter(
            products = products,
            onAddToCart = { product ->
                CartManager.add(product)
                // показати повідомлення користувачу
                Toast.makeText(this, "${product.name} додано в кошик", Toast.LENGTH_SHORT).show()
            },
            onFavorite = { product ->
                product.isFavorite = !product.isFavorite
            }
        )
        recyclerView.adapter = adapter
    }

    private fun loadProducts() {
        products.add(Product(
            id = "1",
            name = "Навушники Sony",
            description = "Бездротові навушники",
            price = 1999.99,
            images = null
        ))
        products.add(Product(
            id = "2",
            name = "Ноутбук ігровий Lenovo LOQ 15ARP9 (83JC00K6RA) Luna Grey",
            description = "15.6\" IPS 144 Гц / AMD Ryzen 5 7235HS / RAM 16 ГБ / SSD 512 ГБ / RTX 3050, 6 ГБ / Зарядка по USB",
            price = 39999.99,
            images = null
        ))
        products.add(Product(
            id = "3",
            name = "Фотокамера Sony ZV-1 Black (ZV1B.CE3)",
            description = "ЖК-екран зі змінним кутом нахилу для зручної зйомки селфі. На відкидному РК-екрані зручно кадрувати зображення під час зйомки селфі та роликів для відеоблогу. Сенсорна панель дозволяє легко керувати фокусуванням, затвором та іншими налаштуваннями навіть під час зйомки селфі, а мікрофон та інші аксесуари не затуляють огляд.",
            price = 25799.00,
            images = null
        ))
    }
}