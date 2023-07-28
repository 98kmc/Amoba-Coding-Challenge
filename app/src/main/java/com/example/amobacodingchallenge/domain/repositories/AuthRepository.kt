package com.example.amobacodingchallenge.domain.repositories

import com.example.amobacodingchallenge.data.authentication.AuthManagerRepresentable
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.data.authentication.firestore_auth.FirebaseAuthManager
import com.example.amobacodingchallenge.domain.entities.UserRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authManager: AuthManagerRepresentable
): RepositoryRepresentable.LoginRepositoryRepresentable {

    override suspend fun signIn(userRequest: UserRequest): UserResponseDTO? {
        return authManager.signIn(userRequest)
    }

    override suspend fun signUp(userRequest: UserRequest) {

    }
}