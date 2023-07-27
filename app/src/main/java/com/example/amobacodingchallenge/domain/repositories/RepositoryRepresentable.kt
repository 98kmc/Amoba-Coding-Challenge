package com.example.amobacodingchallenge.domain.repositories

import com.example.amobacodingchallenge.domain.entities.Patient

interface RepositoryRepresentable {

    interface PatientsRepositoryRepresentable {

        suspend fun fetchAllPatients(): List<Patient>

        suspend fun fetchPatientById(patientId: String): Patient
    }
}
