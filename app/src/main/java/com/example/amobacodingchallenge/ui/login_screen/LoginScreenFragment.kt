package com.example.amobacodingchallenge.ui.login_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.LoginScreenFragmentBinding

class LoginScreenFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    private var _binding: LoginScreenFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createListeners()
        setObservers()
    }

    private fun setObservers() {

    }

    private fun navigateToPatientListScreen() {
        findNavController().navigate(
            LoginScreenFragmentDirections.actionLoginScreenFragmentToPatientListContainerFragment()
        )
    }

    private fun createListeners() {

        binding.signInButtom.setOnClickListener {
            viewModel.didTapSingInButton(
                binding.usernameEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }
}