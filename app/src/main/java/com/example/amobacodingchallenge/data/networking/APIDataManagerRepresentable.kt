package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientDTO

interface APIDataManagerRepresentable {

    suspend fun fetchAllPatients(): List<PatientDTO>

    suspend fun fetchPatientById(patientId: String): PatientDTO
}