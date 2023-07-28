package com.example.amobacodingchallenge.ui.patient_list_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.LoginScreenFragmentBinding
import com.example.amobacodingchallenge.databinding.PatientListContainerFragmentBinding
import com.example.amobacodingchallenge.ui.main.MainActivity
import com.example.amobacodingchallenge.ui.patient_list_screen.patient_list_recyclerview.PatientListAdapter
import com.example.amobacodingchallenge.ui.patient_list_screen.patient_list_recyclerview.PatientListRecyclerViewFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PatientListContainerFragment : Fragment() {

    private val viewModel: PatientListViewModel by viewModels()

    private var _binding: PatientListContainerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PatientListContainerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCharacterListRecyclerView()
        configureToolbar()
    }
    private fun configureToolbar() {

        val toolbar = (requireActivity() as MainActivity).binding.mainToolbar
        toolbar.visibility = View.INVISIBLE

        //status bar color
        val window: Window = requireActivity().window
        window.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.amoba_blue)
    }

    private fun setUpCharacterListRecyclerView() {

        val recyclerViewFragment =
            PatientListRecyclerViewFragment.newInstance(viewModel = viewModel) { patientId ->
                navigateToDetailScreen(patientId)
            }

        childFragmentManager
            .beginTransaction()
            .replace(binding.patientListRecyclerviewContainer.id, recyclerViewFragment)
            .commit()
    }

    private fun navigateToDetailScreen(characterId: Int) {
//        findNavController().navigate(
//            PatientListContainerFragmentDirections.actionCharacterListScreenFragmentToCharacterDetailFragment(
//                characterId
//            )
//        )
    }
}