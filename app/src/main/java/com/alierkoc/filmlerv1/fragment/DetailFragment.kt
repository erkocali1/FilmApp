package com.alierkoc.filmlerv1.fragment

import android.app.Application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alierkoc.filmlerv1.databinding.FragmentDetailBinding
import com.alierkoc.filmlerv1.model.detail.MovieDetailResult
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.viewmodel.DetailViewModel
import com.bumptech.glide.Glide

class DetailFragment : Fragment() {
    private lateinit var viewModel:DetailViewModel
    private lateinit var binding: FragmentDetailBinding
    private lateinit var detailMovies : ArrayList<MovieDetailResult>
    private lateinit var application: Application





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        application = requireActivity().application
        //getting ıd from other fragment
        val movieId=arguments?.getString("movie_Id").toString()
        val backdropPath=arguments?.getString("backdropPath")
        val name=arguments?.getString("name")

        viewModel=ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.getDataDetail(movieId)
        obserLiveData()





         //Add to room
        binding.fabButton.setOnClickListener {
            val favList = FavList(0, name!!, backdropPath!!)
            viewModel.saveRoom(favList, application)
        }

    }

    fun obserLiveData(){
        viewModel.detailMoviesData.observe(viewLifecycleOwner, Observer { film->

            film?.let {
                detailMovies= arrayListOf()
                displayData(film)
            }
        })
    }

    fun displayData(movieDetailResult: MovieDetailResult) {
        binding.detailExplain.text=movieDetailResult.overview
        binding.detailName.text=movieDetailResult.title
        binding.popularity.text=movieDetailResult.homepage


        val genreList=movieDetailResult.genres.map { it.name }
        val genreString=genreList.joinToString(" /","")
        binding.genres.text=genreString

        val url = "https://image.tmdb.org/t/p/w500/${movieDetailResult.backdropPath}"
        Glide.with(requireContext())
            .load(url)
            .into(binding.detailImage)

}
}