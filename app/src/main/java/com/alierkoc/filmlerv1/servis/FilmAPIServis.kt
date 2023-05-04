package com.alierkoc.filmlerv1.servis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FilmAPIServis{

  private  val BASE_URL="https://example.com/"
    private val userApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(FilmAPI::class.java)

    fun getData()=userApi.getFilmInformation()

}