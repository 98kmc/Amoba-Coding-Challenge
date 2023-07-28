package com.example.amobacodingchallenge.ui.patient_list_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.LoginScreenFragmentBinding
import com.example.amobacodingchallenge.databinding.PatientListContainerFragmentBinding

class PatientListContainerFragment : Fragment() {

    private var _binding: PatientListContainerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PatientListContainerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}