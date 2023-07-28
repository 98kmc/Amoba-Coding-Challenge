package com.example.amobacodingchallenge.domain.entities

import com.example.amobacodingchallenge.data.networking.firestore.dto.IntegerValue
import com.example.amobacodingchallenge.data.networking.firestore.dto.MapValue
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientLocationDTO
import com.example.amobacodingchallenge.data.networking.firestore.dto.StringValue
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
    var name: String,
    var phoneNumber: String,
    var email: String,
    var age: String,
    val number: Int,
    var gender: Gender,
    var address: String,
    var location: PatientLocation,
)
data class Patient(
    var number: Int,
    var name: String,
    var image: String?
)
