package com.alierkoc.filmlerv1.model.tvDetail


import com.google.gson.annotations.SerializedName

data class TvGenreDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)