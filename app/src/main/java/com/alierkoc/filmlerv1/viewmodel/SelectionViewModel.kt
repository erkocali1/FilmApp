package com.alierkoc.filmlerv1.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alierkoc.filmlerv1.model.FilmFavDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SelectionViewModel:ViewModel() {


    fun deleteAllFromRoom(application:Application){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val dataBase = FilmFavDataBase.getInstance(application)
                val filmDao = dataBase.favFilmDao()
                filmDao.deleteAllFav()
            }
        }

    }

}