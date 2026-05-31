package com.example.shop.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shop.MainActivity
import com.example.shop.R
import com.example.shop.data.UserManager

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Заповніть всі поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (UserManager.login(email, password)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Невірний email або пароль", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Заповніть всі поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (UserManager.register(email, password)) {
                Toast.makeText(this, "Реєстрація успішна! Тепер увійдіть.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Користувач вже існує!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}