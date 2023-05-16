package com.alierkoc.filmlerv1.viewmodel


import android.content.Context

import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.FilmFavDataBase

import com.alierkoc.filmlerv1.servis.FilmDAO

class FavouritesViewModel :ViewModel() {

    private lateinit var dataBase: FilmFavDataBase
    private lateinit var fdao: FilmDAO


}





