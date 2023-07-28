package com.example.amobacodingchallenge.ui.patient_detail_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.use_cases.PatientUseCases
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable.PatientUseCasesRepresentable
import com.example.amobacodingchallenge.ui.patient_list_screen.PatientListViewModelState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class PatientDetailViewModel @Inject constructor(
    private val patientUseCases: PatientUseCasesRepresentable
) : ViewModel() {

    private var _state = MutableStateFlow(PatientDetailViewModelState())
    val state get() = _state.asStateFlow()

    private suspend fun getPatientsById(id: String): Patient = suspendCoroutine { continuation ->
        var currentPatient: Patient? = null

        patientUseCases.getPatientById(id).onEach { response ->
            when(response) {
                is Resource.Success -> {
                    currentPatient = response.data
                    Log.d("VM1", "getPatientsS: ${response.data}")
                }

                is Resource.Failure -> {
                    _state.value = PatientDetailViewModelState(error = response.message.toString())
                    Log.d("VM1", "getPatientsF: ${response.message}")
                }
                is Resource.Loading -> {
                    _state.value = PatientDetailViewModelState(isLoading = true)
                    Log.d("VM1", "getPatientsL: ${response.data}")
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class PatientDetailViewModelState(
    var currentPatient: Patient? = null,
    var error: String = "",
    var isLoading: Boolean = false
)