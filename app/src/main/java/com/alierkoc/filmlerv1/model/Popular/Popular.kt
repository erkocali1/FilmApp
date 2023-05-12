package com.alierkoc.filmlerv1.model.Popular

import com.alierkoc.filmlerv1.model.Popular.ResultResponse
import com.google.gson.annotations.SerializedName

data class Popular(
    @SerializedName("page")
    val page : Int,
    @SerializedName("results")
    val results : ArrayList<ResultResponse>,
    @SerializedName("total_result")
    val total_result : Int,
    @SerializedName("total_pages")
    val total_pages : Int
)
