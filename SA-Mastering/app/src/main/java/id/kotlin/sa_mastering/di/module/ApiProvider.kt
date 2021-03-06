package id.kotlin.sa_mastering.di.module

import dagger.Module
import dagger.Provides
import id.kotlin.sa_mastering.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object ApiProvider {

    @Provides
    @Singleton
    fun provideHttpAdapter(client: OkHttpClient):Retrofit{
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(BuildConfig.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        }.build()
    }
    @Provides
    @Singleton
    fun provideHttpClient(interceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            addInterceptor(interceptor)
        }.build()
    }
    @Provides
    @Singleton
    fun provideHttpLogging():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().apply {
            level = when(BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}