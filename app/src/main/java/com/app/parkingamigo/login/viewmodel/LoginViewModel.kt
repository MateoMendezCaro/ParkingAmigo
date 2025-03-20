package com.app.parkingamigo.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.domain.usecases.LoginUseCase
import kotlinx.coroutines.launch
import com.example.data.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getInstance(application).userDao()
    private val userRepository = UserRepository(userDao)
    private val loginUseCase = LoginUseCase(userRepository)

    init {
        viewModelScope.launch {
            userRepository.insertTestUser()
        }
    }

    fun login(cedula: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val success = loginUseCase.login(cedula, password)
            onResult(success)
        }
    }
}