package com.olehmesh.repository.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/news")
    suspend fun getData(@Query("limit") loadSize: Int = 30, @Query("after") after: Int = 20, @Query("before") before: Int = 20): Response<ApiResponse>

}