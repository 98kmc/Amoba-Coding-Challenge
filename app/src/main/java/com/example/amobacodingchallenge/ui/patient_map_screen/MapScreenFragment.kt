package com.example.amobacodingchallenge.ui.patient_map_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.navArgs
import com.example.amobacodingchallenge.ui.patient_detail_screen.PatientDetailFragmentArgs

class MapScreenFragment : Fragment() {

    private lateinit var composeView: ComposeView

    private val args: MapScreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        composeView.setContent {
            MapScreenView(args.patientLocation)
        }
    }

}