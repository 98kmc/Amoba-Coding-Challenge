package com.example.amobacodingchallenge.domain.entities

import java.util.Date

enum class Gender(val value: String) {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    companion object {
        fun allValues() = values().map { it.value }

        fun fromValue(value: String) = values().find { it.value == value } ?: UNKNOWN
    }
}

data class PatientLocation(
    var longitude: Double,
    var latitude: Double,
)
data class PatientDetail(
    var phoneNumber: Int,
    var email: String,
    var age: String,
    val patientId: String,
    var gender: Gender,
    var address: String,
    var location: PatientLocation
)
data class Patient(
    var id: String,
    var name: String,
    var image: String?
)
