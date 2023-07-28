package com.example.amobacodingchallenge.domain.use_cases

import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable.LoginUseCasesRepresentable
import com.example.amobacodingchallenge.domain.repositories.RepositoryRepresentable.LoginRepositoryRepresentable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class LoginUseCases @Inject constructor(
    private val repository: LoginRepositoryRepresentable
) : LoginUseCasesRepresentable{

    override fun singIn(userRequest: UserRequest): Flow<Resource<UserResponseDTO?>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.signIn(userRequest)
            emit(Resource.Success(response))
        } catch (error: IOException) {
            emit(Resource.Failure("No internet Access"))
        } catch (error: Exception) {
            emit(Resource.Failure(error.message.toString()))
        }
    }

    override fun logOut() {
        TODO("Not yet implemented")
    }


}