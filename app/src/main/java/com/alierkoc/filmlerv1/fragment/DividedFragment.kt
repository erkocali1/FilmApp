package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.FragmentDividedBinding

class DividedFragment : Fragment() {
    private lateinit var binding: FragmentDividedBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentDividedBinding.inflate(layoutInflater,container,false)


        binding.cardMovie.setOnClickListener {

            val action=DividedFragmentDirections.actionDividedFragmentToMovieFragment()
            findNavController().navigate(action)

        }

        binding.cardTvShow.setOnClickListener {

            val action=DividedFragmentDirections.actionDividedFragmentToMovieFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}