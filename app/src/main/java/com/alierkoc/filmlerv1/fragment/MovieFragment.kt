package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.adapter.moveiadapters.MovieAdapter
import com.alierkoc.filmlerv1.adapter.moveiadapters.MovieTrendAdapter
import com.alierkoc.filmlerv1.adapter.moveiadapters.MovieUpComingAdapter
import com.alierkoc.filmlerv1.databinding.FragmentMovieBinding
import com.alierkoc.filmlerv1.model.Popular.ResultResponse
import com.alierkoc.filmlerv1.model.trend.TrendResult
import com.alierkoc.filmlerv1.model.upComing.UpComingResult
import com.alierkoc.filmlerv1.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    private lateinit var binding: FragmentMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var recyclerMovieAdapter : MovieAdapter
    private lateinit var recyclerTrendAdapter: MovieTrendAdapter
    private lateinit var recyclerUpcomingAdapter: MovieUpComingAdapter
    private lateinit var popularMovies : ArrayList<ResultResponse>
    private lateinit var trendMovies:ArrayList<TrendResult>
    private lateinit var upComingMovies:ArrayList<UpComingResult>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        binding.rv1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewModel.getPopular()

        binding.rv2.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        viewModel.getTrend("movie","week")

        binding.rv3.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        viewModel.getUpcoming()

        observeLiveData()


    }

    private fun observeLiveData() {

        viewModel.popularMoviesData.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.loadData.visibility=View.GONE
                binding.errorMassage.visibility=View.GONE
                popularMovies = arrayListOf()
                popularMovies.addAll(it.results)
                recyclerMovieAdapter = MovieAdapter(popularMovies,requireContext()){item->

                    val bundle=Bundle()
                    bundle.putString("movie_Id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.title)
                    findNavController().navigate(R.id.action_movieFragment_to_detailFragment,bundle)


                }
                binding.rv1.adapter = recyclerMovieAdapter
            }
        })

        viewModel.trendMoviesData.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.loadData.visibility=View.GONE
                binding.errorMassage.visibility=View.GONE
                trendMovies= arrayListOf()
                trendMovies.addAll(it.results)
                recyclerTrendAdapter= MovieTrendAdapter(trendMovies,requireContext()){ item->
                    val bundle=Bundle()
                    bundle.putString("movie_Id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.title)
                    findNavController().navigate(R.id.action_movieFragment_to_detailFragment,bundle)
                }
                binding.rv2.adapter=recyclerTrendAdapter
            }
        })

        viewModel.upComingMoviesData.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.loadData.visibility=View.GONE
                binding.errorMassage.visibility=View.GONE
                upComingMovies= arrayListOf()
                upComingMovies.addAll(it.results)
                recyclerUpcomingAdapter= MovieUpComingAdapter(upComingMovies,requireContext()){item->
                    val bundle=Bundle()
                    bundle.putString("movie_Id",item.id.toString())
                    bundle.putString("backdropPath", item.backdropPath)
                    bundle.putString("name", item.title)
                    findNavController().navigate(R.id.action_movieFragment_to_detailFragment,bundle)
                }
                binding.rv3.adapter=recyclerUpcomingAdapter
            }
        })

    }


}
