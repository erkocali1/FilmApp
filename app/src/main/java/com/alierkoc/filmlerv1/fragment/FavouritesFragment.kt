package com.alierkoc.filmlerv1.fragment

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       binding=FragmentFavouritesBinding.inflate(layoutInflater,container,false)
        return binding.root



    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        viewModel = ViewModelProvider(this).get(FavouritesViewModel::class.java)
        application = requireActivity().application
        favList = ArrayList()

        recyclcerFavAdapter = FavAdapter(favList, requireContext()) { filmId ->
            viewModel.deleteFromRoom(application, filmId)
        }
        binding.rvFav.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFav.adapter = recyclcerFavAdapter





        observeLiveData()



    }

    private fun observeLiveData() {
        viewModel.getFromRoom(application).observe(viewLifecycleOwner) { favListFromRoom ->
            favList.clear()
            favList.addAll(favListFromRoom)
            recyclcerFavAdapter.notifyDataSetChanged()
        }


    }


}