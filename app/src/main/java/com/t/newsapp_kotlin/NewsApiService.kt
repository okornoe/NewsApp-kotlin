package com.t.newsapp_kotlin

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "f7566e894ffd42f389814d672b2714cf"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("top-headlines?country=us&apiKey=${API_KEY}")
    fun getProperties():
            Call<String>
}

object NewsApi {
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java) }
}