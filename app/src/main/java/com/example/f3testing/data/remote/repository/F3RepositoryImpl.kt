package com.example.f3testing.data.remote.repository

import android.util.Log
import com.example.f3testing.data.remote.F3Api
import com.example.f3testing.domain.model.BannerDateModel
import com.example.f3testing.domain.model.ProfileResponseModel
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.domain.model.VillaDetails
import com.example.f3testing.domain.repository.F3Repository
import com.example.f3testing.util.Resource


class F3RepositoryImpl (private val getAllServicesApi: F3Api
) : F3Repository {

    override suspend fun getAllServices(
        authorization: String,
        acceptLanguage: String,
        villaId: String
    ): Resource<List<ServicesDataModel?>?> {

        return try {
            val response = getAllServicesApi.getAllServices(authorization = authorization, acceptLanguage =acceptLanguage, villaId = villaId)
            Resource.Success(response.data)

        } catch (e: Exception) {
            Log.v("home screen services" , e.message.toString())
            Resource.Error(message = "Failed to fetch Services ${e.message}")

        }
    }

    override suspend fun getBanners(
        authorization: String,
        acceptLanguage: String,
        villaId: String
    ): Resource<List<BannerDateModel?>?> {
        return try {
            val bannerRespose = getAllServicesApi.getBanners(authorization = authorization, acceptLanguage =acceptLanguage, villaId = villaId)
            Resource.Success(bannerRespose.data)
        }
        catch (e: Exception){
            Resource.Error(e.message)
        }
    }

    override suspend fun getVillaList(
        authorization: String,
        acceptLanguage: String,
        villaId: String
    ): Resource<List<VillaDetails>> {
        return try {
            val villaList = getAllServicesApi.getVillaList(authorization = authorization, acceptLanguage =acceptLanguage, villaId = villaId)
            Resource.Success(villaList.data)
        }
        catch (e:Exception){
            Resource.Error(e.message)
        }
    }

    override suspend fun getUserProfile(
        authorization: String,
        acceptLanguage: String,
        villaId: String
    ): Resource<ProfileResponseModel> {
        return try {
            val userData = getAllServicesApi.getUserProfileData(authorization = authorization, acceptLanguage =acceptLanguage, villaId = villaId)
            Resource.Success(userData.data)
        }
        catch ( e:Exception){
            Resource.Error(e.message)
        }
    }


}