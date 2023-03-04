package com.example.sable

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface API {

    @GET("poi.json?location_id=Paris&tag_labels=cuisine")  //path do resursa, nalepljen na baseUrl
    suspend fun getDog(
        @Query("account") apiKey:String,
        @Query("token") token: String
    ): Response<Data>
}