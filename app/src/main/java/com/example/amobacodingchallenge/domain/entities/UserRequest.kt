package com.example.amobacodingchallenge.domain.entities

data class UserRequest(
val email: String,
val password: String,
val returnSecureToken: Boolean = true
)
