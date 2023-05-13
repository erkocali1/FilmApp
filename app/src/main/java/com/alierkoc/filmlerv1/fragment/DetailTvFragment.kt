package com.alierkoc.filmlerv1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.FragmentDetailTvBinding


class DetailTvFragment : Fragment() {
    private lateinit var  binding:FragmentDetailTvBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentDetailTvBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}