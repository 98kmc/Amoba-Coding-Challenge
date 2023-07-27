package com.example.amobacodingchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.amobacodingchallenge.R
import com.example.amobacodingchallenge.domain.use_cases.PatientUseCases
import androidx.lifecycle.lifecycleScope
import com.example.amobacodingchallenge.common.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var useCases: PatientUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        useCases.getAllPatients().onEach { response ->
            when(response) {
                is Resource.Success -> Log.d("MainActivity", "onStart: ${response.data}")

                is Resource.Failure -> Log.d("MainActivity", "onStart: ${response.data}")

                is Resource.Loading -> {}
            }
        }.launchIn(lifecycleScope)
    }
}