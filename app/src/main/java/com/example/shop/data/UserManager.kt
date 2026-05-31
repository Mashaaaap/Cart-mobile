package com.example.shop.data

object UserManager {
    private val users = mutableMapOf<String, String>() // email → password
    var currentUser: String? = null

    fun register(email: String, password: String): Boolean {
        if (users.containsKey(email)) return false // вже існує
        users[email] = password
        return true
    }

    fun login(email: String, password: String): Boolean {
        if (users[email] == password) {
            currentUser = email
            return true
        }
        return false
    }

    fun isLoggedIn() = currentUser != null

    fun logout() {
        currentUser = null
    }
}