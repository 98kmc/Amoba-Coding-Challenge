package com.example.amobacodingchallenge.domain.entities

import java.util.Date

data class Patient(
    var name: String?,
    var lastname: String?,
    var phoneNumber: String?,
    var status: String?,
    var email: String?,
    var birthDate: Date?,
    var gender: String?,
    var address: PatientAddress
)
