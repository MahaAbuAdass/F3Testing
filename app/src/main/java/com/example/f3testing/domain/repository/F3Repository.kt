package com.example.f3testing.domain.repository

import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.util.Resource


interface F3Repository {

    suspend fun getAllServices(
        authorization: String,
        acceptLanguage: String ,
        villaId: String
    ): Resource<List<ServicesDataModel?>?>

}