package com.example.amobacodingchallenge.domain.entities

enum class Gender(val value: String) {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    companion object {
        fun allValues() = values().map { it.value }

        fun fromValue(value: String) = values().find { it.value == value } ?: UNKNOWN
    }
}

data class Patient(
    var name: String,
    var lastname: String,
    var phoneNumber: Int,
    var email: String,
    var age: String,
    var gender: Gender,
    var address: PatientAddress
)
