package com.example.f3testing.data.remote

import com.example.f3testing.domain.model.BannerResponseModel
import com.example.f3testing.domain.model.ProfileResponseModel
import com.example.f3testing.domain.model.ServicesResponseModel
import com.example.f3testing.domain.model.UserInfo
import com.example.f3testing.domain.model.VillaListResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface F3Api {


    @GET("Services/GetAllServices")
    suspend fun getAllServices(
        @Header("Authorization") authorization: String,
        @Header("Accept-Language") acceptLanguage: String ,
        @Header("VillaId") villaId: String
    ): ServicesResponseModel



    @GET("Banner/GetAll")
    suspend fun getBanners(
        @Header("Authorization") authorization: String,
        @Header("Accept-Language") acceptLanguage: String ,
        @Header("VillaId") villaId: String
    ): BannerResponseModel


    @GET("Services/GetUserVillas")
    suspend fun getVillaList(
        @Header("Authorization") authorization: String,
        @Header("Accept-Language") acceptLanguage: String ,
        @Header("VillaId") villaId: String
    ) : VillaListResponse

    @GET("Auth/GetUserProfile")
    suspend fun getUserProfileData(
        @Header("Authorization") authorization: String,
        @Header("Accept-Language") acceptLanguage: String ,
        @Header("VillaId") villaId: String
    ) : UserInfo



    companion object
    {
        const val BASE_URL = "http://40.115.6.93:8111/api/"
    }

}