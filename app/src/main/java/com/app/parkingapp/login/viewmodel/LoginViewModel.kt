package com.app.parkingapp.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val correctCedula = "123456789"
    private val correctPassword = "admin123"

    fun login(cedula: String, password: String) {
        viewModelScope.launch {
            if (cedula == correctCedula && password == correctPassword) {
                _loginSuccess.value = true
                _errorMessage.value = null
            } else {
                _loginSuccess.value = false
                _errorMessage.value = "Credenciales incorrectas"
            }
        }
    }
}
