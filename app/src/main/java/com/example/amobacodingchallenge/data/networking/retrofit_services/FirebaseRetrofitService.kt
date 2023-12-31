package com.example.amobacodingchallenge.data.networking.retrofit_services

import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.Document
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDetailsDTO
import com.example.amobacodingchallenge.domain.entities.UserRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FirebaseRetrofitService {

    interface FirestoreRetrofitService {
        @GET("(default)/documents/currentPatients")
        suspend fun fetchAllPatients(): List<Document<PatientDTO>>

        @GET("(default)/documents/currentPatients/{patientId}/details/details")
        suspend fun fetchPatientById(
            @Path("patientId") patientId: String
        ): Document<PatientDetailsDTO>
    }

    interface FirebaseAuthRetrofitService {
        @POST("accounts:signInWithPassword?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
        suspend fun signIn(
            @Body userRequestDTO: UserRequest
        ): UserResponseDTO?

        @POST("accounts:signUp?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
        suspend fun signUp(
            @Body userRequestDTO: UserRequest
        ): UserResponseDTO?
    }
}