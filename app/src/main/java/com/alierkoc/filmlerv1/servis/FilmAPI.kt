package com.alierkoc.filmlerv1.servis

import com.alierkoc.filmlerv1.model.MovieDetailResult
import com.alierkoc.filmlerv1.model.Popular
import com.alierkoc.filmlerv1.model.Trend
import com.alierkoc.filmlerv1.model.TrendResult
import com.alierkoc.filmlerv1.model.UpComing
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmAPI {


    //https://api.themoviedb.org/3/movie/popular?api_key=1ae81a0b7ff5aa1b20644e098cf3cd41&page=3
    //Acsess page
    //api_key=1ae81a0b7ff5aa1b20644e098cf3cd41&page=3

    //https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    //Search
    //https://api.themoviedb.org/3/search/movie?api_key=1ae81a0b7ff5aa1b20644e098cf3cd41&query=Jack+Reacher

    //Fetch İmage
    //https://image.tmdb.org/t/p/w500
    //https://image.tmdb.org/t/p/w500/2v3pC01rf0uXnECOM94pjfqk1TY.jpg

    @GET("movie/popular")
    fun getPopular():Call<Popular>

    @GET("trending/{media_type}/{time_window}")
    fun getTrend(
        @Path("media_type")media_type:String,
        @Path("time_window")time_window:String,):Call<Trend>

    @GET("movie/upcoming")
    fun getUpcomig():Call<UpComing>

    @GET("movie/{movie_id}")
    fun getDetail(
        @Path("movie_id")movie_id:String):Call<MovieDetailResult>


}