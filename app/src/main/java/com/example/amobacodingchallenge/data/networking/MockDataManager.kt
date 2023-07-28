package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientLocationDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDetailsDTO
import com.example.amobacodingchallenge.data.networking.retrofit_services.firestore.FirebaseRetrofitService
import java.util.Date
import javax.inject.Inject

class MockDataManager  @Inject constructor() : ApiDataManagerRepresentable {
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