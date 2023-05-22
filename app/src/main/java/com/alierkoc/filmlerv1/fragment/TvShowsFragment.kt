package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.adapter.tvadapters.TvAiringTodayAdapter
import com.alierkoc.filmlerv1.adapter.tvadapters.TvPopularAdapter
import com.alierkoc.filmlerv1.adapter.tvadapters.TvTopRatedAdapter
import com.alierkoc.filmlerv1.databinding.FragmentTvShowsBinding
import com.alierkoc.filmlerv1.model.tvAiringToday.TvAiringTodayResult
import com.alierkoc.filmlerv1.model.tvPopular.TvResult
import com.alierkoc.filmlerv1.model.tvTopRated.TvTopRated
import com.alierkoc.filmlerv1.model.tvTopRated.TvTopRatedResult
import com.alierkoc.filmlerv1.viewmodel.TvShowsViewModel


class TvShowsFragment : Fragment() {
    private lateinit var binding:FragmentTvShowsBinding
    private lateinit var viewmodel:TvShowsViewModel
    private lateinit var tvResult: ArrayList<TvResult>
    private lateinit var tvTopRatedResult:ArrayList<TvTopRatedResult>
    private lateinit var tvAiringTodayResult:ArrayList<TvAiringTodayResult>
    private lateinit var recyclerTvPopularAdapter:TvPopularAdapter
    private lateinit var recyclerTvTopRatedAdapter: TvTopRatedAdapter
    private lateinit var recyclerTvAiringToday:TvAiringTodayAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentTvShowsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel=ViewModelProvider(requireActivity()).get(TvShowsViewModel::class.java)

        binding.rv1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewmodel.getTvPopular(4)
        observeLiveData()

        binding.rv2.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewmodel.getTvToprated()

        binding.rv3.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewmodel.getTvAiringToday(2)

    }


    private fun observeLiveData(){


        viewmodel.tvResultData.observe(viewLifecycleOwner, Observer{
            it?.let {
                tvResult= arrayListOf()
                tvResult.addAll(it.results)
                recyclerTvPopularAdapter= TvPopularAdapter(tvResult,requireContext())
                {item->
                    val bundle=Bundle()
                    bundle.putString("tv_id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.name)
                    findNavController().navigate(R.id.action_tvShowsFragment_to_detailTvFragment,bundle)

                }
                binding.rv1.adapter=recyclerTvPopularAdapter
            }
        })


        viewmodel.tvTopratedData.observe(viewLifecycleOwner, Observer {
            it?.let {
                tvTopRatedResult= arrayListOf()
                tvTopRatedResult.addAll(it.results)
                recyclerTvTopRatedAdapter= TvTopRatedAdapter(tvTopRatedResult,requireContext()){item->
                    val bundle=Bundle()
                    bundle.putString("tv_id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.name)
                    findNavController().navigate(R.id.action_tvShowsFragment_to_detailTvFragment,bundle)
                }
            }
            binding.rv2.adapter=recyclerTvTopRatedAdapter
        })

        viewmodel.tvAiringTodayData.observe(viewLifecycleOwner, Observer {
            it?.let {
                tvAiringTodayResult= arrayListOf()
                tvAiringTodayResult.addAll(it.results)
                recyclerTvAiringToday= TvAiringTodayAdapter(tvAiringTodayResult,requireContext()){item->
                    val bundle=Bundle()
                    bundle.putString("tv_id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.name)
                    findNavController().navigate(R.id.action_tvShowsFragment_to_detailTvFragment,bundle)

                }
            }
            binding.rv3.adapter=recyclerTvAiringToday
        })



    }

}