package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import com.example.amobacodingchallenge.domain.entities.Patient

interface ApiDataManagerRepresentable {

    suspend fun fetchAllPatients(): List<PatientDTO>

    suspend fun fetchPatientById(patientId: String): PatientDTO
}