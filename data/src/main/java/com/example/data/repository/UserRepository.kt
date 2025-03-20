package com.example.data.repository

import com.example.data.local.UserDao
import com.example.data.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun authenticate(cedula: String, password: String): Boolean {
        return userDao.authenticate(cedula, password) != null
    }

    suspend fun insertTestUser() {
        userDao.insertUser(User("12345678", "admin"))
    }
}