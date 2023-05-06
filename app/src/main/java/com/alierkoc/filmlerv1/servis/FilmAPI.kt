package com.alierkoc.filmlerv1.servis

import com.alierkoc.filmlerv1.model.FilmData
import retrofit2.Call
import retrofit2.http.GET

interface FilmAPI {

    @GET("/movie/{movie_id}")
    fun getFilmInformation():Call<List<FilmData>>
}