package com.example.amobacodingchallenge.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
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

@Parcelize
data class PatientLocation(
    var longitude: Double,
    var latitude: Double,
) : Parcelable

data class PatientDetail(
    var phoneNumber: String,
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
    var lastname: String,

    var image: String?,
    var detail: PatientDetail
)
