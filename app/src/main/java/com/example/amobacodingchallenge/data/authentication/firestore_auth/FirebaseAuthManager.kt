package com.example.amobacodingchallenge.data.authentication.firestore_auth

import com.example.amobacodingchallenge.data.authentication.AuthManagerRepresentable
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.data.networking.retrofit_services.FirebaseRetrofitService
import com.example.amobacodingchallenge.data.sharedPreferences.SessionManager
import com.example.amobacodingchallenge.domain.entities.UserRequest
import javax.inject.Inject

class FirebaseAuthManager @Inject constructor(
    private val api: FirebaseRetrofitService.FirebaseAuthRetrofitService,
    private val sessionManager: SessionManager
): AuthManagerRepresentable {

    override suspend fun signUp(userRequest: UserRequest): UserResponseDTO? {
        val response = api.signUp(userRequest)
        sessionManager.saveAuthToken(response?.idToken ?: "")
        return response
    }

    override suspend fun signIn(userRequest: UserRequest): UserResponseDTO? {
        val response = api.signUp(userRequest)
        sessionManager.saveAuthToken(response?.idToken ?: "")
        return response
    }

}