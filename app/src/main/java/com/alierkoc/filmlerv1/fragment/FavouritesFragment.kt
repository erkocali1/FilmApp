package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.adapter.FavAdapter
import com.alierkoc.filmlerv1.databinding.FragmentFavouritesBinding
import com.alierkoc.filmlerv1.model.fav.FavList


class FavouritesFragment : Fragment() {
    private lateinit var binding:FragmentFavouritesBinding
    private lateinit var favList:ArrayList<FavList>
    private lateinit var recylcerFavAdapter: FavAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       binding=FragmentFavouritesBinding.inflate(layoutInflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFav.layoutManager=LinearLayoutManager(requireContext())
       recylcerFavAdapter= FavAdapter(favList,requireContext())
        binding.rvFav.adapter=recylcerFavAdapter
    }
}