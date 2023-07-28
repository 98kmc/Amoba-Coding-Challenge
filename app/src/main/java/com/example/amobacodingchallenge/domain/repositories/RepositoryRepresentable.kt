package com.example.amobacodingchallenge.domain.repositories

import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.UserRequest

interface RepositoryRepresentable {

    interface PatientsRepositoryRepresentable {

        suspend fun fetchAllPatients(): List<Patient>

        suspend fun fetchPatientById(patientId: String): Patient
    }

    interface LoginRepositoryRepresentable {

        suspend fun signIn(userRequest: UserRequest): UserResponseDTO?

        suspend fun signUp(userRequest: UserRequest)
    }
}
