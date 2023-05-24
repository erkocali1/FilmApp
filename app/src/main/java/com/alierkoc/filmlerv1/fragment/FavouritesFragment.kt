package com.alierkoc.filmlerv1.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alierkoc.filmlerv1.adapter.FavAdapter
import com.alierkoc.filmlerv1.databinding.FragmentFavouritesBinding
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.viewmodel.FavouritesViewModel


class FavouritesFragment : Fragment() {
    private lateinit var binding:FragmentFavouritesBinding
    private lateinit var favList:ArrayList<FavList>
    private lateinit var recyclcerFavAdapter: FavAdapter
    private lateinit var viewModel:FavouritesViewModel
    private lateinit var application: Application
    private lateinit var favorites:ArrayList<FavList>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       binding=FragmentFavouritesBinding.inflate(layoutInflater,container,false)
        return binding.root



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)
        application = requireActivity().application
        viewModel.getFromRoom(application)

        binding.rvFav.layoutManager = LinearLayoutManager(requireContext())

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.favouritesRoomLiveData.observe(viewLifecycleOwner, Observer { favListFromRoom ->
            favListFromRoom?.let {
                favorites = ArrayList(it)
                recyclcerFavAdapter = FavAdapter(favorites, requireContext()) { filmId ->
                    favorites.removeIf { fav -> fav.uid == filmId }
                    recyclcerFavAdapter.notifyDataSetChanged()
                    viewModel.deleteFromRoom(application, filmId)
                }
                binding.rvFav.adapter = recyclcerFavAdapter
            }
        })
    }
}