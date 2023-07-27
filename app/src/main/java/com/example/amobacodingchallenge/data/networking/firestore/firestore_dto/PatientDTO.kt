package com.example.amobacodingchallenge.data.networking.firestore.firestore_dto

import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.PatientAddress
import java.util.Date

data class PatientDTO(
    var name: String?,
    var lastname: String?,
    var phoneNumber: String?,
    var email: String?,
    var birthDate: Date?,
    var gender: String?,
    var address: PatientAddressDTO
)

fun PatientDTO.calculateAge(): String {
    return ""
}
fun PatientDTO.toPatientObject(): Patient {
    return Patient(
        this.name ?: "",
        this.lastname ?: "",
        this.phoneNumber?.toInt() ?: 0,
        this.email ?: "",
        this.calculateAge(),
        "Masculino",
        PatientAddress(
            "street",
            0.0007172,
            0.000454788
        )

    )
}