package com.t.newsapp_kotlin

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsapi.org/v2/"
private const val API_KEY = "f7566e894ffd42f389814d672b2714cf"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService {
    @GET("top-headlines?country=us&apiKey=${API_KEY}")
    fun getProperties():
            Call<NewsData>
}

object NewsApi {
    val retrofitService : NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java) }
}