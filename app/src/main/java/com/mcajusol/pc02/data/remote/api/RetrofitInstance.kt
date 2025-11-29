package com.mcajusol.pc02.data.remote.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://v3.football.api-sports.io/"
private const val API_FOOTBALL_KEY = "b6177a72452bab38c2942e5801fc7e39"

object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(Interceptor{ chain->
            val request = chain.request().newBuilder()
                .addHeader("x-apisports-key", API_FOOTBALL_KEY)
                .build()
            chain.proceed(request)
        }).build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }
}