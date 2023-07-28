package com.example.amobacodingchallenge.domain.repositories

import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(

): RepositoryRepresentable.LoginRepositoryRepresentable {

    override suspend fun signIn(userRequest: UserRequest): UserResponseDTO {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(userRequest: UserRequest): UserResponseDTO {
        TODO("Not yet implemented")
    }
}