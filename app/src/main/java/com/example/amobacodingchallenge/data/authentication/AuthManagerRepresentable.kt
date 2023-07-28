package com.example.amobacodingchallenge.data.authentication

import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest

interface AuthManagerRepresentable {

    suspend fun signUP(userRequest: UserRequest) : UserResponseDTO

    suspend fun logOut()
}