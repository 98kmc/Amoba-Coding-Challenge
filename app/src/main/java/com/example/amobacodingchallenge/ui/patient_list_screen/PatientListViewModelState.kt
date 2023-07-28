package com.example.amobacodingchallenge.ui.patient_list_screen

import com.example.amobacodingchallenge.domain.entities.Patient

data class PatientListViewModelState (
    var patientList: MutableList<Patient> = mutableListOf(),
    var error: String = "",
    var isLoading: Boolean = false
)