package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientAddressDTO
import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.PatientDTO
import java.util.Date
import javax.inject.Inject

class MockDataManager  @Inject constructor() : APIManagerRepresentable {
    override suspend fun fetchAllPatients(): List<PatientDTO> {
        return (0..20).map {
            PatientDTO(
                name = "patient/${it}",
                lastname = "lastname",
                phoneNumber = "11111111",
                email = "example.com",
                birthDate = Date(),
                gender = "m",
                address = PatientAddressDTO(
                    "street",
                    "00007172",
                    "00000454788"
                )
            )
        }
    }

    override suspend fun fetchPatientById(patientId: String): PatientDTO {
       return PatientDTO(
           name = "patient 1",
           lastname = "lastname",
           phoneNumber = "11111111",
           email = "example.com",
           birthDate = Date(),
           gender = "m",
           address = PatientAddressDTO(
               "street",
               "00007172",
               "00000454788"
           )
       )
    }


}