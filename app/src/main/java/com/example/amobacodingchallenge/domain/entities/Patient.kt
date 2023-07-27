package com.example.amobacodingchallenge.domain.entities

import java.util.Date

data class Patient(
    var name: String,
    var lastname: String,
    var phoneNumber: Int,
    var email: String,
    var age: String,
    var gender: String,
    var address: PatientAddress
)
