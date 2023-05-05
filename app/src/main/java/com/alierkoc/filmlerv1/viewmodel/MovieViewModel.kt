package com.alierkoc.filmlerv1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.FilmData

class MovieViewModel:ViewModel() {

    val movie= MutableLiveData<List<FilmData>>()
    val errorMessage= MutableLiveData<Boolean>()
    val loadingMovie= MutableLiveData<Boolean>()

    fun refreshData(){


        val mv1=FilmData("hello")
        val fimListTest= arrayListOf<FilmData>(mv1)

        movie.value=fimListTest
        errorMessage.value=false
        loadingMovie.value=false


    }
}