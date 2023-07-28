package com.example.amobacodingchallenge.ui.login_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: UseCasesRepresentable.LoginUseCasesRepresentable
) : ViewModel() {

    private var _shouldNavigateToPatientList = MutableStateFlow(false)
    val shouldNavigateToPatientList get() = _shouldNavigateToPatientList.asStateFlow()

    private var _error = MutableStateFlow("")
    val error get() = _error.asStateFlow()

    private var _isLoading = MutableStateFlow(false)
    val isLoading get() = _isLoading.asStateFlow()

    fun didTapSingInButton(email: String, password: String) {
        val loginRequest = UserRequest(
            email,
            password,
            true,
        )

        loginUseCases.singIn(loginRequest).onEach { response ->
            when(response) {
                is Resource.Success -> {
                     if(response.data == null) {
                         _error.emit("Usuario no encontrado")
                     } else {
                         navigateToPatientList(response.data)
                     }
                    _error.emit("")
                    _isLoading.emit(false)
                }
                is Resource.Failure -> _error.emit(response.message.toString())
                is Resource.Loading -> _isLoading.emit(true)
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun navigateToPatientList(userResponseDTO: UserResponseDTO) {

        _shouldNavigateToPatientList.emit(true)
    }
}