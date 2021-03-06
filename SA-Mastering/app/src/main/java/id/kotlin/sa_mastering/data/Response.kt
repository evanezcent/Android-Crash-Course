package id.kotlin.sa_mastering.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("results")
    val res:List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview:String
)