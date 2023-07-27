package com.example.amobacodingchallenge.data.networking.firestore.firestore_dto

import com.example.amobacodingchallenge.domain.entities.Gender
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.PatientAddress
import java.util.Date

data class PatientDetailsDTO(
    val patientId: String?,
    var phoneNumber: String?,
    var email: String?,
    var birthDate: Date?,
    var gender: String?,
    var address: String?,
    var location: PatientLocationDTO?
)
data class PatientDTO(
    var id: String?,
    var name: String?,
    var lastname: String?,
    var image: String?,
    var detail: PatientDetailsDTO
)

fun PatientDTO.calculateAge(): String {
    return ""
}
fun PatientDTO.toPatientObject(): Patient {
    return Patient(
        this.name ?: "",
        this.lastname ?: "",
        this.detail.phoneNumber?.toInt() ?: 0,
        this.detail.email ?: "",
        this.calculateAge(),
        Gender.fromValue(this.detail.gender.toString()),
        PatientAddress(
            this.detail.address ?: "",
            this.detail.location?.longitude?.toDouble() ?: 0.0007172,
            this.detail.location?.latitude?.toDouble() ?: 0.000454788
        )
    )
}