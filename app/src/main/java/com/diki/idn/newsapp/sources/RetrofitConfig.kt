package com.diki.idn.newsapp.sources

import com.diki.idn.newsapp.common.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    private val retrofitConfiguration by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiServiceClient: ApiServices by lazy {
        retrofitConfiguration.create(ApiServices::class.java)
    }
}