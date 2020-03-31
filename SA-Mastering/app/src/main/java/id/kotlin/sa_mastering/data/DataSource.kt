package id.kotlin.sa_mastering.data

import id.kotlin.sa_mastering.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface DataSource{

    @GET("/3/discover/movie")
    fun getMovie(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Single<Response>
}