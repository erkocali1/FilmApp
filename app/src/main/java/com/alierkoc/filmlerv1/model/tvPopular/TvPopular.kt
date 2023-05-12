package com.alierkoc.filmlerv1.model.tvPopular


import com.google.gson.annotations.SerializedName

data class TvPopular(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TvResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)