package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alierkoc.filmlerv1.databinding.FragmentDetailTvBinding
import com.alierkoc.filmlerv1.model.tvDetail.TvDetail
import com.alierkoc.filmlerv1.viewmodel.TvShowsDetailViewModel
import com.bumptech.glide.Glide


class DetailTvFragment : Fragment() {
    private lateinit var  binding:FragmentDetailTvBinding
    private  lateinit var viewModel:TvShowsDetailViewModel
    private lateinit var tvShowsDetailResult:ArrayList<TvDetail>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDetailTvBinding.inflate(layoutInflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //getting ıd from other fragment

        val tvId=arguments?.getString("tv_id")
        let {
            tvId?.let {
                viewModel=ViewModelProvider(this).get(TvShowsDetailViewModel::class.java)
                viewModel.getDataTvShowDetail(tvId)
                observeLiveData()
            }
        }
    }

    fun observeLiveData(){
        viewModel.getTvDetailData.observe(viewLifecycleOwner, Observer {tv->

            tv?.let {
            tvShowsDetailResult= arrayListOf()
            displayData(tv)
        }

        })

}
    fun displayData(tvDetailResult: TvDetail) {
        binding.detailExplain.text=tvDetailResult.overview
        binding.detailName.text=tvDetailResult.name
        binding.popularity.text=tvDetailResult.homepage


        val genreList=tvDetailResult.genres.map { it.name }
        val genreString=genreList.joinToString(" /","")
        binding.genres.text=genreString


        val url = "https://image.tmdb.org/t/p/w500/${tvDetailResult.backdropPath}"
        Glide.with(requireContext())
            .load(url)
            .into(binding.detailImage)

    }
}