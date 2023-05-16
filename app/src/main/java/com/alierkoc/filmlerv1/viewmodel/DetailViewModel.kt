package com.alierkoc.filmlerv1.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.alierkoc.filmlerv1.model.FilmFavDataBase
import com.alierkoc.filmlerv1.model.detail.MovieDetailResult
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import com.alierkoc.filmlerv1.servis.FilmDAO

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailViewModel(application: Application) : AndroidViewModel(application) {

    val detailMoviesData = MutableLiveData<MovieDetailResult>()
    private val service = FilmAPIServis()
    private lateinit var fdao: FilmDAO



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

    val db=Room.databaseBuilder(
        application,FilmFavDataBase::class.java,"filmbase-name"
    ).build()

    fun saveRoom(favList: FavList, filmDao: FilmDAO) {


        filmDao.insertAll(favList)


    }
}
