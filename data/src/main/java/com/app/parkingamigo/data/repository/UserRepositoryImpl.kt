package com.app.parkingamigo.data.repository

import com.app.parkingamigo.data.local.UserDao
import com.app.parkingamigo.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun authenticate(cedula: String, password: String): Boolean {
        return userDao.authenticate(cedula, password) != null
    }
}