package com.example.amobacodingchallenge.data.authentication.dto

data class UserRequestDTO (
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)