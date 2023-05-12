package com.alierkoc.filmlerv1.ui.activies

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alierkoc.filmlerv1.R
import com.alierkoc.filmlerv1.databinding.ActivitySelectionBinding
import com.alierkoc.filmlerv1.viewmodel.MovieViewModel
import com.alierkoc.filmlerv1.viewmodel.SelectionViewModel

class SelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectionBinding
    private lateinit var viewModel:SelectionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProvider(this)[SelectionViewModel ::class.java]

    }


}