package com.example.amobacodingchallenge.domain.use_cases

import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.UserRequest
import kotlinx.coroutines.flow.Flow

interface UseCasesRepresentable {

    interface PatientUseCasesRepresentable {

        fun getAllPatients(): Flow<Resource<List<Patient>>>

        fun getPatientById(patientId: String): Flow<Resource<Patient>>
    }

    interface LoginUseCasesRepresentable {

       // fun singUp(userRequest: UserRequest): Flow<Resource<UserResponseDTO>>

        fun singIn(userRequest: UserRequest): Flow<Resource<UserResponseDTO?>>

        fun logOut()
    }
}