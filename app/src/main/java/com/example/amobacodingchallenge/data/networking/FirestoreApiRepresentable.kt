package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface FirestoreApiRepresentable {

    @GET("(default)/documents/currentPatients")
    suspend fun fetchAllPatients(): List<PatientDTO>

    @GET("(default)/documents/currentPatients/{patientId}")
    suspend fun fetchPatientById(
        @Path("patientId") patientId: String
    ): PatientDTO
}