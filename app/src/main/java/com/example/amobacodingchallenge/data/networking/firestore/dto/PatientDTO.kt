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
    val location: MapValue<PatientLocationDTO>? = null
)

fun PatientDetailsDTO.calculateAge(): String {
    return ""
}
fun PatientDetailsDTO.toPatientDetailObject(): PatientDetail {
    return PatientDetail(
        name = this.name?.stringValue ?: "no name",
        phoneNumber = this.phone?.stringValue ?: "No number",
        email = this.email?.stringValue ?: "",
        age = this.calculateAge(),
        gender = Gender.fromValue(this.gender?.stringValue.toString()),
        address = this.address?.stringValue ?: "",
        number = this.number?.integerValue ?: 0,
        location =  PatientLocation(
            this.location?.mapValue?.longitude?.stringValue?.toDouble() ?: 0.000000,
            this.location?.mapValue?.latitude?.stringValue?.toDouble() ?: 0.000000
        )
    )
}
data class PatientDTO(
    val number: IntegerValue? = null,
    val name: StringValue? = null,
    val image: StringValue? = null
) {
    fun toPatientObject(): Patient {
        return Patient(
            number = this.number?.integerValue ?: 0,
            name = this.name?.stringValue ?: "",
            image = this.image?.stringValue,
        )
    }
}

