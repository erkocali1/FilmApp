package com.alierkoc.filmlerv1.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alierkoc.filmlerv1.model.FilmFavDataBase
import com.alierkoc.filmlerv1.model.detail.MovieDetailResult
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailViewModel(application: Application) : AndroidViewModel(application) {

    val detailMoviesData = MutableLiveData<MovieDetailResult>()
    private val service = FilmAPIServis()



    fun getDataDetail(gettingDetail: String) {

        val response = service.getDataDetail(gettingDetail)

        response.enqueue(object : Callback<MovieDetailResult> {
            override fun onResponse(
                call: Call<MovieDetailResult>,
                response: Response<MovieDetailResult>
            ) {
                if (response.isSuccessful) {
                    detailMoviesData.value = response.body()
                }

            }

            override fun onFailure(call: Call<MovieDetailResult>, t: Throwable) {
                Log.i("getDataDetail service", "onFailure: $t")
            }

        })

    }



    fun saveRoom(favList: FavList, application: Application) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataBase = FilmFavDataBase.getInstance(application)
                val filmDao = dataBase.favFilmDao()
                filmDao.insertAll(favList)
            }
        }
    }

}
