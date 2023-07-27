package com.example.amobacodingchallenge.domain.use_cases

import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.domain.entities.Doctor
import com.example.amobacodingchallenge.domain.entities.Patient
import kotlinx.coroutines.flow.Flow

interface UseCasesRepresentable {

    interface PatientUseCasesRepresentable {

        fun getAllPatients(): Flow<Resource<List<Patient>>>

        fun getPatientById(patientId: String): Flow<Resource<Patient>>
    }

    interface LoginUseCasesRepresentable {

        fun singUp(): Doctor
    }
}