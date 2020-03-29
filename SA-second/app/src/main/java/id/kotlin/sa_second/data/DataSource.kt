package id.kotlin.sa_second.data

import id.kotlin.sa_second.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataSource{

    @GET("/3/discover/movie")
    fun getMovie(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Call<Response>
}