package com.diki.idn.newsapp.sources

import com.diki.idn.newsapp.common.API_KEY
import com.diki.idn.newsapp.common.END_POINT_HEADLINES
import com.diki.idn.newsapp.model.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiServices {
    @GET("$END_POINT_HEADLINES?country=${com.diki.idn.newsapp.common.COUNTRY}&apiKey=$API_KEY")
    fun getHeadlineNews(): Observable<ApiResponse>
}