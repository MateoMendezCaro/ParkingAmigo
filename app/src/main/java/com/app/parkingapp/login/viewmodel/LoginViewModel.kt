package com.app.parkingapp.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.parkingamigo.domain.model.User
import com.app.parkingamigo.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData

    fun login(cedula: String, password: String) {
        viewModelScope.launch {
            try {
                // 💡 Lógica de acceso rápido para pruebas locales
                if (cedula == "xxx" && password == "123") {
                    _userData.value = User(
                        id = "demo001",
                        nombre = "Test",
                        apellidos = "Usuario",
                        correo = "test@example.com",
                        cedula = "xxx"
                    )
                    _loginSuccess.value = true
                    _errorMessage.value = null
                    return@launch
                }

                val user = loginUseCase.login(cedula, password)
                if (user != null) {
                    _loginSuccess.value = true
                    _errorMessage.value = null
                    _userData.value = user
                } else {
                    _loginSuccess.value = false
                    _errorMessage.value = "Cédula o contraseña incorrectas"
                }
            } catch (e: Exception) {
                _loginSuccess.value = false
                _errorMessage.value = "Error de red: ${e.message}"
            }
        }
    }
}
