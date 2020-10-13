package com.hcid.app.data.source.remote.network

import com.hcid.app.data.source.remote.response.HomeResponse
import retrofit2.http.GET

interface ApiService {

    @GET("home")
    suspend fun getHomeData():HomeResponse

}