package com.example.amobacodingchallenge.ui.patient_list_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amobacodingchallenge.common.Resource
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.use_cases.UseCasesRepresentable.PatientUseCasesRepresentable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@HiltViewModel
class PatientListViewModel @Inject constructor(
    private val patientUseCases: PatientUseCasesRepresentable
) : ViewModel() {

    var state = MutableStateFlow(PatientListViewModelState())
        private set

    fun recyclerDidMadeRefreshGesture() {
        refresh()
    }

    // Private_Methods
    private fun refresh() {
        viewModelScope.launch {
            val patientList = getPatients()
            state.value = PatientListViewModelState(patientList.toMutableList())
        }
    }

    private suspend fun getPatients(): List<Patient> = suspendCoroutine { continuation ->
        var patientList: List<Patient> = emptyList()

        patientUseCases.getAllPatients().onEach { response ->
            when(response) {
                is Resource.Success -> {
                    patientList = response.data ?: emptyList()
                    Log.d("VM1", "getPatientsS: ${response.data}")
                }

                is Resource.Failure -> {
                    state.value = PatientListViewModelState(error = response.message.toString())
                    Log.d("VM1", "getPatientsF: ${response.message}")
                }
                is Resource.Loading -> {
                    state.value = PatientListViewModelState(isLoading = true)
                    Log.d("VM1", "getPatientsL: ${response.data}")
                }
            }

            if (response is Resource.Success || response is Resource.Failure) {
                continuation.resume(patientList)
            }
        }.launchIn(viewModelScope)
    }
}