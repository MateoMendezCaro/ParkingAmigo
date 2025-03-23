package com.app.parkingapp.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun login(cedula: String, password: String) {
        viewModelScope.launch {
            if (cedula == "e123456" && password == "456") {
                _loginSuccess.value = true
                _errorMessage.value = null
            } else {
                _loginSuccess.value = false
                _errorMessage.value = "Cédula o contraseña incorrectas"
            }
        }
    }
}
