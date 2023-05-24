package com.alierkoc.filmlerv1.fragment

import android.app.Application

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
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

            //Fav button efekt
            binding.fabButton.alpha=0.5f
            val handlerThread=HandlerThread("HandlerThread")
            handlerThread.start()
            val looper = handlerThread.looper
            val handler = Handler(looper)
            handler.postDelayed({
               binding.fabButton.alpha = 1.0f
                handlerThread.quit()
            }, 200)

        }

    }

    fun obserLiveData(){
        viewModel.detailMoviesData.observe(viewLifecycleOwner, Observer { film->

            film?.let {
                detailMovies= arrayListOf()
                displayData(film)
            }
        })

        viewModel.load.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    binding.loadData.visibility=View.VISIBLE
                    binding.detailImage.visibility=View.GONE
                    binding.detailName.visibility=View.GONE
                    binding.detailExplain.visibility=View.GONE
                    binding.genres.visibility=View.GONE
                    binding.ExplainConstant.visibility=View.GONE
                    binding.genresConstant.visibility=View.GONE
                    binding.popularity.visibility=View.GONE
                    binding.popularityConstant.visibility=View.GONE
                }
                else{
                    binding.loadData.visibility=View.GONE
                    binding.detailImage.visibility=View.VISIBLE
                    binding.detailName.visibility=View.VISIBLE
                    binding.detailExplain.visibility=View.VISIBLE
                    binding.genres.visibility=View.VISIBLE
                    binding.ExplainConstant.visibility=View.VISIBLE
                    binding.genresConstant.visibility=View.VISIBLE
                    binding.popularity.visibility=View.VISIBLE
                    binding.popularityConstant.visibility=View.VISIBLE
                }

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