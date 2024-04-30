package com.example.f3testing.data.remote

import com.example.f3testing.domain.model.ServicesResponseModel
import retrofit2.http.GET
import retrofit2.http.Header

interface F3Api {


    @GET("Services/GetAllServices")
    suspend fun getAllServices(
        @Header("Authorization") authorization: String,
        @Header("Accept-Language") acceptLanguage: String ,
        @Header("VillaId") villaId: String
    ): ServicesResponseModel





    companion object
    {
        const val BASE_URL = "http://40.115.6.93:8111/api/"
    }

}