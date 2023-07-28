package com.example.amobacodingchallenge.data.networking.firestore.dto

import com.example.amobacodingchallenge.domain.entities.Gender
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.PatientDetail
import com.example.amobacodingchallenge.domain.entities.PatientLocation
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
        id = this.id ?: "",
        name =this.name ?: "",
        lastname = this.lastname ?: "",
        image = this.image,
        detail = PatientDetail(
            phoneNumber = this.detail.phoneNumber?.toInt() ?: 0,
            email = this.detail.email ?: "",
            age = this.calculateAge(),
            gender = Gender.fromValue(this.detail.gender.toString()),
            address = this.detail.address ?: "",
            patientId = this.detail.patientId ?: "",
            location =  PatientLocation(
            this.detail.location?.longitude?.toDouble() ?: 0.0007172,
            this.detail.location?.latitude?.toDouble() ?: 0.000454788
            )
        )
    )
}