package com.example.bankofrussia.data.network


import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object ApiFactory {

    private const val BASE_URL = "https://www.cbr.ru/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}