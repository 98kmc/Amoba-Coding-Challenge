package com.example.amobacodingchallenge.data.networking

import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientLocationDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientDetailsDTO
import com.example.amobacodingchallenge.domain.entities.Gender
import com.example.amobacodingchallenge.domain.entities.PatientLocation
import java.util.Date
import javax.inject.Inject

//class MockDataManager  @Inject constructor() : ApiDataManagerRepresentable {
//    override suspend fun fetchAllPatients(): List<PatientDTO> {
//        return (0..20).map {
////
////
////            PatientDTO(
////                number = "$it",
////                name =  "patient/${it}",
////                image =    "lastname",
////            )
////        }
//    }
//
//    override suspend fun fetchPatientById(patientId: String): PatientDTO {
////        return  PatientDTO(
////            "1",
////            "patient/1",
////            "lastname",
////            "",
////            PatientDetailsDTO(
////                "1",
////                "example.com",
////                "",
////                Date(),
////                "Masculino",
////                "street",
////                PatientLocationDTO(
////                    "00007172",
////                    "00000454788"
////                )
////            )
////
////        )
//    }
//}