package com.alierkoc.filmlerv1.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.FragmentDividedBinding
import com.alierkoc.filmlerv1.ui.activies.SelectionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class DividedFragment : Fragment() {
    private lateinit var binding: FragmentDividedBinding
    private lateinit var activity: SelectionActivity


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDividedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.cardMovie.setOnClickListener {
            val action = DividedFragmentDirections.actionDividedFragmentToMovieFragment()
            findNavController().navigate(action)
        }
        binding.cardTvShow.setOnClickListener {

            val action = DividedFragmentDirections.actionDividedFragmentToTvShowsFragment()
            findNavController().navigate(action)
        }
    }

}