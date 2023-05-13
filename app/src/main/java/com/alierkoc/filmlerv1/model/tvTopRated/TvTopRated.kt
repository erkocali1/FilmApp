package com.alierkoc.filmlerv1.model.tvTopRated


import com.google.gson.annotations.SerializedName

data class TvTopRated(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvTopRatedResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)