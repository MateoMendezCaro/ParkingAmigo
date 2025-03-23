/*
package com.app.parkingamigo.data.repository

import com.app.parkingamigo.data.local.UserDao
import com.app.parkingamigo.data.model.User
import com.app.parkingamigo.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun authenticate(cedula: String, password: String): Boolean {
        return userDao.getUser(cedula, password) != null
    }

    suspend fun insertTestUser() {
        userDao.insertUser(User("e123456", "456"))
    }
}*/
