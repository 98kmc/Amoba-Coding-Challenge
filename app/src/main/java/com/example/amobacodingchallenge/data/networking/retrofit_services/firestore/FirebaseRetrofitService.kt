package com.example.amobacodingchallenge.data.networking.retrofit_services.firestore

import com.example.amobacodingchallenge.data.authentication.dto.UserRequestDTO
import com.example.amobacodingchallenge.data.authentication.dto.UserResponseDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FirebaseRetrofitService {

    interface FirestoreRetrofitService {
        @GET("(default)/documents/currentPatients")
        suspend fun fetchAllPatients(): List<PatientDTO>

        @GET("(default)/documents/currentPatients/{patientId}")
        suspend fun fetchPatientById(
            @Path("patientId") patientId: String
        ): PatientDTO
    }

    interface FirebaseAuthRetrofitService {
        @POST("accounts:signInWithPassword?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
        suspend fun signIn(
            @Body userRequestDTO: UserRequestDTO
        ): UserResponseDTO

        @POST("accounts:signUp?key=AIzaSyBH2HzhBrqh5uHaKBrXxm8F-LtZ-Hj8tB4")
        suspend fun signUp(
            @Body userRequestDTO: UserRequestDTO
        ): UserResponseDTO
    }
}