package com.example.amobacodingchallenge.ui.patient_detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.amobacodingchallenge.data.networking.firestore.dto.PatientLocationDTO
import com.example.amobacodingchallenge.databinding.LoginScreenFragmentBinding
import com.example.amobacodingchallenge.databinding.PatientDetailFragmentBinding
import com.example.amobacodingchallenge.databinding.PatientListContainerFragmentBinding
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.domain.entities.PatientLocation
import com.example.amobacodingchallenge.ui.patient_list_screen.PatientListContainerFragmentDirections
import com.example.amobacodingchallenge.ui.patient_list_screen.PatientListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PatientDetailFragment : Fragment() {

    private val args: PatientDetailFragmentArgs by navArgs()

    private val viewModel: PatientDetailViewModel by viewModels()

    private var _binding: PatientDetailFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PatientDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPatient(args.patientId)

        viewModel.state.onEach { state ->
            fillTextViews(viewModel.state.value.currentPatient)
        }.launchIn(lifecycleScope)

        setListeners()
    }

    private fun setListeners() {
        binding.closeImageview.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.goToMapbutton.setOnClickListener {
            val location = viewModel.state.value.currentPatient?.detail?.location
            if (location != null) {

                navigateToMapScreen(location)
            }
        }
    }

    private fun navigateToMapScreen(location: PatientLocation) {

        findNavController().navigate(
            PatientDetailFragmentDirections.actionPatientDetailFragmentToMapScreenFragment(
                location
            )
        )
    }

    private fun fillTextViews(currentPatient: Patient?) {

        if (currentPatient == null) { return }
        binding.nameTextview.text = currentPatient.name
        binding.actualPatientTextview.text = "Paciente actual"
        binding.patientNumberTextView.text = currentPatient.detail.patientId
        binding.patientEmailTextView.text = currentPatient.detail.email
        binding.patientAgeYearTextView.text = currentPatient.detail.age
        binding.genderTextView.text = currentPatient.detail.gender.value
        binding.patientAddressTextView.text = currentPatient.detail.address
        binding.patientPhoneTextView.text = currentPatient.detail.phoneNumber
    }
}

