package com.example.amobacodingchallenge.data.networking.auth.dto

data class UserResponseDTO(
    val kind: String? = null,
    val localId: String?  = null,
    val email: String? = null,
    val displayName: String? = null,
    val idToken: String? = null,
    val registered: Boolean? = null,
    val refreshToken: String? = null,
    val expiresIn: String? = null
)
