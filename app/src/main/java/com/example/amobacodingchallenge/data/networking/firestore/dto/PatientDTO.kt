package com.example.amobacodingchallenge.data.networking.firestore.dto

import com.example.amobacodingchallenge.domain.entities.Gender
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.PatientDetail
import com.example.amobacodingchallenge.domain.entities.PatientLocation
import java.util.Date

data class PatientDetailsDTO(
    val number: IntegerValue? = null,
    val name: StringValue? = null,
    val email: StringValue? = null,
    val address: StringValue? = null,
    val phone: StringValue? = null,
    val birthday: StringValue? = null,
    val gender: StringValue? = null,
    val location: MapValue<PatientLocationDTO>? = null,
)
data class PatientDTO(
    val number: IntegerValue? = null,
    val name: StringValue? = null,
    val image: StringValue? = null
)

fun PatientDTO.calculateAge(): String {
    return ""
}