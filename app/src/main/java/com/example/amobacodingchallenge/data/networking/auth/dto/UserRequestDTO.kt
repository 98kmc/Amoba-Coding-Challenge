package com.example.amobacodingchallenge.data.networking.auth.dto

data class UserRequestDTO (
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)