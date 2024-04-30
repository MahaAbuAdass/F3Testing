package com.example.f3testing.data.remote.repository

import com.example.f3testing.data.remote.F3Api
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.domain.repository.F3Repository
import com.example.f3testing.util.Resource
import java.lang.Exception

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
            Resource.Error(message = "Failed to fetch Services ${e.message}")
        }
    }
}