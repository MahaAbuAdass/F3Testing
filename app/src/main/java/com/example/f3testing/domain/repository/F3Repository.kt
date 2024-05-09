package com.example.f3testing.domain.repository

import com.example.f3testing.domain.model.BannerDateModel
import com.example.f3testing.domain.model.ProfileResponseModel
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.domain.model.VillaDetails
import com.example.f3testing.util.Resource


interface F3Repository {

    suspend fun getAllServices(
        authorization: String,
        acceptLanguage: String ,
        villaId: String
    ): Resource<List<ServicesDataModel?>?>

    suspend fun getBanners(
        authorization: String,
        acceptLanguage: String ,
        villaId: String
    ): Resource<List<BannerDateModel?>?>


    suspend fun getVillaList(
        authorization: String,
        acceptLanguage: String ,
        villaId: String
    ) : Resource<List<VillaDetails>>


    suspend fun getUserProfile(
        authorization: String,
        acceptLanguage: String ,
        villaId: String
    ) : Resource<ProfileResponseModel>

}