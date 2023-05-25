package com.alierkoc.filmlerv1.fragment

import android.app.Application
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alierkoc.filmlerv1.databinding.FragmentDetailTvBinding
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.model.tvDetail.TvDetail
import com.alierkoc.filmlerv1.viewmodel.TvShowsDetailViewModel
import com.bumptech.glide.Glide


class DetailTvFragment : Fragment() {
    private lateinit var  binding:FragmentDetailTvBinding
    private  lateinit var viewModel:TvShowsDetailViewModel
    private lateinit var tvShowsDetailResult:ArrayList<TvDetail>
    private lateinit var application: Application

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDetailTvBinding.inflate(layoutInflater,container,false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        application = requireActivity().application


        //getting ıd from other fragment

        val tvId=arguments?.getString("tv_id")
        val backdropPath=arguments?.getString("backdropPath")
        val name=arguments?.getString("name")
        let {
            tvId?.let {
                viewModel=ViewModelProvider(this).get(TvShowsDetailViewModel::class.java)
                viewModel.getDataTvShowDetail(tvId)
                observeLiveData()
            }
        }

        binding.fabButton.setOnClickListener {
            val favList = FavList(0, name!!, backdropPath!!)
            viewModel.saveRoom(favList, application)

            //Fav button efekt
            binding.fabButton.alpha=0.5f
            val handlerThread= HandlerThread("HandlerThread")
            handlerThread.start()
            val looper = handlerThread.looper
            val handler = Handler(looper)
            handler.postDelayed({
                binding.fabButton.alpha = 1.0f
                handlerThread.quit()
            }, 200)
        }


    }

    fun observeLiveData(){
        viewModel.getTvDetailData.observe(viewLifecycleOwner, Observer {tv->

            tv?.let {
            tvShowsDetailResult= arrayListOf()
            displayData(tv)
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
                    binding.fabButton.visibility=View.GONE
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
                    binding.fabButton.visibility=View.VISIBLE
                }
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