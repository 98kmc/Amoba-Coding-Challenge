package com.example.amobacodingchallenge.data.Authentication

import com.example.amobacodingchallenge.data.networking.firestore.firestore_dto.DoctorDTO

interface AutenticationServiceRepresentable {

    interface FirebaseAutenticationServiceRepresentable {

        suspend fun signUp(): DoctorDTO
    }
}