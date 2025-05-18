package com.app.parkingapp.viewModel

import androidx.lifecycle.ViewModel
import com.app.parkingamigo.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SharedUserViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun setUser(user: User) {
        _user.value = user
    }

    fun clearUser() {
        _user.value = null
    }
}
