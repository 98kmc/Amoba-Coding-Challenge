package com.example.amobacodingchallenge.ui.patient_list_screen.patient_list_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.PatientListRecyclerViewFragmentBinding
import com.example.amobacodingchallenge.domain.entities.Patient
import com.example.amobacodingchallenge.ui.patient_list_screen.PatientListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PatientListRecyclerViewFragment : Fragment() {

    lateinit var viewModel: PatientListViewModel
        private set

    lateinit var onClickAction: ((String) -> Unit)
        private set

    private var _binding: PatientListRecyclerViewFragmentBinding? = null
    private val binding get() = _binding!!

    private var patientListAdapter: PatientListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PatientListRecyclerViewFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setObservers()
        setUpRecyclerView(viewModel.state.value.patientList)
        super.onViewCreated(view, savedInstanceState)

        viewModel.recyclerDidMadeRefreshGesture()
    }

    // Private_Methods
    private fun setUpRecyclerView(patientList: List<Patient>) {

        patientListAdapter = PatientListAdapter(patientList.toMutableList(), onClickAction)
        binding.patientListRecyclerview.adapter = patientListAdapter
    }

    private fun setObservers() {

        // viewModel State onChange Listener
        viewModel.state.onEach { state ->

            if (state.error.isBlank() && !state.isLoading) {
                patientListAdapter?.updateData(state.patientList)
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        // SwipeRefreshGesture
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.recyclerDidMadeRefreshGesture()
        }
    }

    companion object {

        fun newInstance(viewModel: PatientListViewModel, onClickAction: ((String) -> Unit)): PatientListRecyclerViewFragment {
            val fragment = PatientListRecyclerViewFragment()
            fragment.viewModel = viewModel
            fragment.onClickAction = onClickAction
            return fragment
        }
    }
}