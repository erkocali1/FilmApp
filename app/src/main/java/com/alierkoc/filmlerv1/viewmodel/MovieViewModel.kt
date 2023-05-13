package com.alierkoc.filmlerv1.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.Popular.Popular
import com.alierkoc.filmlerv1.model.trend.Trend
import com.alierkoc.filmlerv1.model.upComing.UpComing
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModel:ViewModel() {
    private val service = FilmAPIServis()
    val popularMoviesData = MutableLiveData<Popular>()
    val trendMoviesData=MutableLiveData<Trend>()
    val upComingMoviesData=MutableLiveData<UpComing>()
    val load=MutableLiveData<Boolean>()
    val error=MutableLiveData<Boolean>()


    fun getPopular() {
        val response = service.getDataPopular()
        response.enqueue(object : Callback<Popular> {
            override fun onResponse(
                call: Call<Popular>,
                response: Response<Popular>
            ) {
                if (response.isSuccessful) {
                    popularMoviesData.value = response.body()
                    return
                }

            }

            override fun onFailure(call: Call<Popular>, t: Throwable) {
                Log.i("getPopular service", "onFailure: $t")
            }

        })
    }

    fun getTrend(gettingType:String,gettingWindow:String){
        val response=service.getDataTrend(gettingType,gettingWindow)
        response.enqueue(object :Callback<Trend>{
            override fun onResponse(call: Call<Trend>, response: Response<Trend>) {
                if (response.isSuccessful){
                    trendMoviesData.value=response.body()
                }
            }

            override fun onFailure(call: Call<Trend>, t: Throwable) {
                Log.i("getData service", "onFailure: $t")
            }

        })
    }


    fun getUpcoming(){
        val response=service.getDataUpComing()

        response.enqueue(object :Callback<UpComing>{
            override fun onResponse(call: Call<UpComing>, response: Response<UpComing>) {
                if (response.isSuccessful){
                    upComingMoviesData.value=response.body()
                }
            }

            override fun onFailure(call: Call<UpComing>, t: Throwable) {
                Log.i("getUpcoming service", "onFailure: $t")

            }
        })
    }


}