package com.alierkoc.filmlerv1.model


import com.google.gson.annotations.SerializedName

data class FilmData(
    @SerializedName("movie_id")
    var movie_id:String ) {
}