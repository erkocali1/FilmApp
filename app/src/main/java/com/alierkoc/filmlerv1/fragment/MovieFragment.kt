package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.adapter.MovieAdapter
import com.alierkoc.filmlerv1.databinding.FragmentMovieBinding
import com.alierkoc.filmlerv1.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding
    private lateinit var viewModelMovie: MovieViewModel
    private val recyclerMovieAdapter = MovieAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelMovie = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModelMovie.refreshData()

        binding.rv1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rv1.adapter = recyclerMovieAdapter

        observeLiveData()


    }

    fun observeLiveData() {

        viewModelMovie.movie.observe(viewLifecycleOwner, Observer { films ->

            films?.let {


                binding.rv1.visibility = View.VISIBLE
                binding.loadData.visibility=View.GONE
                recyclerMovieAdapter.updateFilmData(films)
            }
        })

        viewModelMovie.errorMessage.observe(viewLifecycleOwner, Observer { error ->
            error?.let {

                if (it) {
                    binding.errorMassage.visibility = View.VISIBLE

                } else {
                    binding.errorMassage.visibility = View.GONE
                }

            }
        })

        viewModelMovie.loadingMovie.observe(viewLifecycleOwner, Observer { loading ->

            loading?.let {
                if (it) {
                    binding.rv1.visibility = View.GONE
                    binding.errorMassage.visibility = View.GONE
                    binding.loadData.visibility=View.VISIBLE

                } else {

                    binding.loadData.visibility = View.GONE

                }
            }

        })

    }

}
