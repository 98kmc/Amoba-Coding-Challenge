package com.example.amobacodingchallenge.data.authentication.firestore_auth

import com.example.amobacodingchallenge.data.authentication.AuthManagerRepresentable
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest

class FirebaseAuthManager : AuthManagerRepresentable{
    override suspend fun signUP(userRequest: UserRequest): UserResponseDTO {

    }

    override suspend fun logOut() {
        TODO("Not yet implemented")
    }
}