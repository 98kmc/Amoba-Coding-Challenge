package com.example.amobacodingchallenge.domain.repositories

import com.example.amobacodingchallenge.data.networking.ApiDataManagerRepresentable
import com.example.amobacodingchallenge.data.networking.retrofit_services.firestore.FirebaseRetrofitService
import com.example.amobacodingchallenge.data.networking.firestore.dto.toPatientObject
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.repositories.RepositoryRepresentable.PatientsRepositoryRepresentable
import javax.inject.Inject

class PatientsRepository @Inject constructor(
    private val dataManager: ApiDataManagerRepresentable
) : PatientsRepositoryRepresentable {

    override suspend fun fetchAllPatients(): List<Patient> {
        val dtoPatientList = dataManager.fetchAllPatients()
        //Convert PatientDTo model to Patient
        return dtoPatientList.map { it.toPatientObject() }
    }

    override suspend fun fetchPatientById(patientId: String) =
        dataManager.fetchPatientById(patientId).toPatientObject()
}