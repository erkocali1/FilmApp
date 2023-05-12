package com.alierkoc.filmlerv1.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.detail.MovieDetailResult
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel:ViewModel() {

    val detailMovies=MutableLiveData<MovieDetailResult>()
    private val service=FilmAPIServis()

    fun getDataDetail(gettingDetail:String){

        val response=service.getDataDetail(gettingDetail)

        response.enqueue(object : Callback<MovieDetailResult> {
            override fun onResponse(call: Call<MovieDetailResult>, response: Response<MovieDetailResult>) {
                if (response.isSuccessful){
                    detailMovies.value=response.body()
                }

            }

            override fun onFailure(call: Call<MovieDetailResult>, t: Throwable) {
                Log.i("getDataDetail service", "onFailure: $t")
            }

        })

    }

}