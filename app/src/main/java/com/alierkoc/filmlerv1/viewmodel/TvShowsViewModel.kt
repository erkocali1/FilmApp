package com.alierkoc.filmlerv1.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alierkoc.filmlerv1.model.tvAiringToday.TvAiringToday
import com.alierkoc.filmlerv1.model.tvPopular.TvPopular
import com.alierkoc.filmlerv1.model.tvTopRated.TvTopRated
import com.alierkoc.filmlerv1.servis.FilmAPIServis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowsViewModel:ViewModel() {
     private  var service=FilmAPIServis()
     var tvResultData=MutableLiveData<TvPopular>()
     var tvTopratedData=MutableLiveData<TvTopRated>()
    var tvAiringTodayData=MutableLiveData<TvAiringToday>()


    fun getTvPopular(gettingPage:Int){

        val response=service.getDataTvPopular(gettingPage)

        response.enqueue(object :Callback<TvPopular>{
            override fun onResponse(call: Call<TvPopular>, response: Response<TvPopular>) {

                if (response.isSuccessful){
                    tvResultData.value=response.body()
                }

            }

            override fun onFailure(call: Call<TvPopular>, t: Throwable) {
                Log.i("getTvPopular service", "onFailure: $t")

            }

        })

    }

    fun getTvToprated(){
        val response=service.getDataTvTopRated()
        response.enqueue(object :Callback<TvTopRated>{
            override fun onResponse(call: Call<TvTopRated>, response: Response<TvTopRated>) {

                if (response.isSuccessful){
                    tvTopratedData.value=response.body()
                }
            }

            override fun onFailure(call: Call<TvTopRated>, t: Throwable) {
                Log.i("getTvToprated service", "onFailure: $t")
            }

        })
    }

    fun getTvAiringToday(gettingPage: Int){
        val response=service.getDataTvAiringToday(gettingPage)
        response.enqueue(object :Callback<TvAiringToday>{
            override fun onResponse(call: Call<TvAiringToday>, response: Response<TvAiringToday>) {
                if (response.isSuccessful){
                    tvAiringTodayData.value=response.body()
                }

            }

            override fun onFailure(call: Call<TvAiringToday>, t: Throwable) {
                Log.i("getTvAiringToday service", "onFailure: $t")
            }

        })



    }


}