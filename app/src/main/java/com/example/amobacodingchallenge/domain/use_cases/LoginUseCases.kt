package com.example.amobacodingchallenge.domain.use_cases

import com.example.amobacodingchallenge.data.Authentication.AutenticationServiceRepresentable.FirebaseAutenticationServiceRepresentable
import javax.inject.Inject

class LoginUseCases @Inject constructor(
    private val service: FirebaseAutenticationServiceRepresentable
) {


}