package id.kotlin.sa_second

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    fun provideHttpAdapter():Retrofit{
        return Retrofit.Builder().apply {
            client(provideHttpClient())
            baseUrl(BuildConfig.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    private fun provideHttpClient():OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(provideHttpLogging())
        }.build()
    }

    private fun provideHttpLogging():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = when(BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}