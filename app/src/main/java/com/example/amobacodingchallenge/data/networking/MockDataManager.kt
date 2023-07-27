package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientLocationDTO
import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientDTO
import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientDetailsDTO
import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.calculateAge
import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.toPatientObject
import com.example.amobacodingchallenge.domain.entities.Gender
import com.example.amobacodingchallenge.domain.entities.PatientAddress
import java.util.Date
import javax.inject.Inject

class MockDataManager  @Inject constructor() : APIDataManagerRepresentable {
    override suspend fun fetchAllPatients(): List<PatientDTO> {
        return (0..20).map {
            PatientDTO(
                "$it",
                "patient/${it}",
                "lastname",
                "",
                PatientDetailsDTO(
                    "$it",
                    "example.com",
                    "",
                    Date(),
                    "Masculino",
                     "street",
                     PatientLocationDTO(
                        "00007172",
                        "00000454788"
                    )
                )

            )
        }
    }

    override suspend fun fetchPatientById(patientId: String): PatientDTO {
       return  PatientDTO(
           "1",
           "patient/1",
           "lastname",
           "",
           PatientDetailsDTO(
               "1",
               "example.com",
               "",
               Date(),
               "Masculino",
               "street",
               PatientLocationDTO(
                   "00007172",
                   "00000454788"
               )
           )

       )
    }


}