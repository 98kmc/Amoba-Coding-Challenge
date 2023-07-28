package com.example.amobacodingchallenge.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amobacodingchallenge.R
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.amobacodingchallenge.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    val binding get() = _binding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            val isLogged = async { checkIfUserIsLogged() }
            val startDestination = if (isLogged.await()) {
                R.id.PatientListContainerFragment
            } else {
                R.id.LoginScreenFragment
            }
            setUpNavHostFragment(startDestination)
        }
    }
    private fun setUpNavHostFragment(startDestination: Int) {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(binding.mainToolbar)

        val navGraph = navController.navInflater.inflate(R.navigation.main_nav_graph)
        navGraph.setStartDestination(startDestination)
        navController.graph = navGraph

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    private suspend fun checkIfUserIsLogged(): Boolean {
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}