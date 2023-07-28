package com.example.amobacodingchallenge.data.networking.firestore

import com.example.amobacodingchallenge.data.networking.ApiDataManagerRepresentable
import com.example.amobacodingchallenge.data.networking.firestore.dto.Document
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDetailsDTO
import javax.inject.Inject

class FirestoreDataManager @Inject constructor() : ApiDataManagerRepresentable {

    override suspend fun fetchAllPatients(): List<PatientDTO> {
        return emptyList()

    }

    // override suspend fun fetchPatientById(patientId: String): PatientDetailsDTO {
//        TODO("Not yet implemented")
//    }


}