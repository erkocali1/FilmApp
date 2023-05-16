package com.alierkoc.filmlerv1.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivitySelectionBinding
import com.alierkoc.filmlerv1.viewmodel.SelectionViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class SelectionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectionBinding
    private lateinit var viewModel: SelectionViewModel
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bottomNavigationView: BottomNavigationView = binding.bottomNavView
        viewModel = ViewModelProvider(this)[SelectionViewModel::class.java]

        binding.bottomNavView.background = null
        bottomNavigationView.menu.getItem(1).isEnabled = false

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupWithNavController(binding.bottomNavView, navController)

        binding.fab.setOnClickListener {
            navController.popBackStack()
            navController.navigate(R.id.movieFragment)
        }


    }
}