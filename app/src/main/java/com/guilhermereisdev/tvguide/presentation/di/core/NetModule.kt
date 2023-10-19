package com.guilhermereisdev.tvguide.presentation.di.core

import com.guilhermereisdev.tvguide.BuildConfig
import com.guilhermereisdev.tvguide.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val tagInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val requestWithTags = originalRequest.newBuilder()
                .header("accept", "application/json")
                .header("Authorization", "Bearer ${BuildConfig.ACCESS_TOKEN}")
                .build()
            chain.proceed(requestWithTags)
        }

        val networkInterceptor = HttpLoggingInterceptor()
        networkInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val client = OkHttpClient.Builder()
            .addInterceptor(tagInterceptor)
            .addNetworkInterceptor(networkInterceptor)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}
