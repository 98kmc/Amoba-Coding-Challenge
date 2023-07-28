package com.example.amobacodingchallenge.domain.entities

import java.io.Serializable

data class UserRequest(
val email: String,
val password: String,
val returnSecureToken: Boolean = true
): Serializable
