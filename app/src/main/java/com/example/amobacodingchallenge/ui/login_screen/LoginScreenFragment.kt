package com.example.amobacodingchallenge.ui.login_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.databinding.LoginScreenFragmentBinding

class LoginScreenFragment : Fragment() {

    private var _binding: LoginScreenFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}