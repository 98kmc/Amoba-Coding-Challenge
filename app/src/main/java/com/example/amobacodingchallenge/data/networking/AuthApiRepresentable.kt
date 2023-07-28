package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.auth.dto.UserRequestDTO
import com.example.amobacodingchallenge.data.networking.auth.dto.UserResponseDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiRepresentable {

    @POST("accounts:signInWithPassword?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
    suspend fun signIn(
        @Body userRequestDTO: UserRequestDTO
    ): UserResponseDTO

    @POST("accounts:signUp?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
    suspend fun signUp(
        @Body userRequestDTO: UserRequestDTO
    ): UserResponseDTO

}