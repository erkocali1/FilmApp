package com.alierkoc.filmlerv1.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.trend.Trend
import com.alierkoc.filmlerv1.model.tvDetail.TvDetail
import com.alierkoc.filmlerv1.servis.FilmAPI
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsDetailViewModel : ViewModel() {
    private val service = FilmAPIServis()
    var getTvDetailData =MutableLiveData<TvDetail>()

    fun getDataTvShowDetail(gettingId: String) {
        val response=service.getDataTvShowDetail(gettingId)
        response.enqueue(object :Callback<TvDetail>{
            override fun onResponse(call: Call<TvDetail>, response: Response<TvDetail>) {
                if (response.isSuccessful){
                    getTvDetailData.value=response.body()
                    Log.i("TV Detail Data", "${response.body()}")
                }
                else{
                    Log.i("FailDataTv", "API Error: ${response.code()}")
                }

            }

            override fun onFailure(call: Call<TvDetail>, t: Throwable) {
                Log.i("getTvDetailData service", "onFailure: $t")
            }

        })
    }

}