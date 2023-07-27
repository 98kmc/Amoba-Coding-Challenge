package com.example.amobacodingchallenge.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable.PatientUseCasesRepresentable
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val patientUseCases: PatientUseCasesRepresentable
) : ViewModel() {

    init {
        patientUseCases.getAllPatients().onEach { response ->
            when(response) {
                is Resource.Success -> Log.d("MainActivity", "onStart: ${response.data}")

                is Resource.Failure -> Log.d("MainActivity", "onStart: ${response.data}")

                is Resource.Loading -> {}
            }
        }.launchIn(viewModelScope)
    }
}