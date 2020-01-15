package com.example.wongnaiandroidassignment.data.network

import com.example.wongnaiandroidassignment.data.model.DataResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("coins")
    fun getCoins(
        @Query("limit") limit: String = "10",
        @Query("offset") offset: String = "0",
        @Query("timePeriod") period: String = "24h"
    ): Single<DataResponse>

    @GET("coins")
    fun searchCoins(@Query("prefix") prefix: String): Single<DataResponse>
}