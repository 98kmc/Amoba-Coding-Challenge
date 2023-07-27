package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientDTO
import com.example.amobacodingchallenge.domain.entities.Patient

interface APIManagerRepresentable {

    suspend fun fetchAllPatients(): List<PatientDTO>

    suspend fun fetchPatientById(patientId: String): PatientDTO
}