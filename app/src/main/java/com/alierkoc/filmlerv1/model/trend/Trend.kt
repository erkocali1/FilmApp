package com.alierkoc.filmlerv1.model.trend


import com.alierkoc.filmlerv1.model.trend.TrendResult
import com.google.gson.annotations.SerializedName

data class Trend(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TrendResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)