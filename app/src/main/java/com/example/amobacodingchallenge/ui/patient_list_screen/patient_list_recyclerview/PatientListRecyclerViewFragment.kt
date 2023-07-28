package com.example.amobacodingchallenge.ui.patient_list_screen.patient_list_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amobacodingchallenge.R

class PatientListRecyclerViewFragment : Fragment() {

    lateinit var onClickAction: ((Int) -> Unit)
        private set

    private var _binding: PatientListRecyclerViewFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PatientListContainerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

}