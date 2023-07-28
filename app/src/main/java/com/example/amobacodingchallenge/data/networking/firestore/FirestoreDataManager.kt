package com.example.amobacodingchallenge.data.networking.firestore

import com.example.amobacodingchallenge.data.networking.ApiDataManagerRepresentable
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import javax.inject.Inject

class FirestoreDataManager @Inject constructor() : ApiDataManagerRepresentable {

    override suspend fun fetchAllPatients(): List<PatientDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPatientById(patientId: String): PatientDTO {
        TODO("Not yet implemented")
    }


}