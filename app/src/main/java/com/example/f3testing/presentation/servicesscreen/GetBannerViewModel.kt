package com.example.f3testing.presentation.servicesscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f3testing.domain.model.BannerDateModel
import com.example.f3testing.domain.repository.F3Repository
import com.example.f3testing.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GetBannerViewModel @Inject constructor( private val bannerRepository : F3Repository)  : ViewModel() {

    var authorization =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJ0ZXN0OTBAZ21haWwuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiYjQ0NjQwODYtN2IwNy00MjU1LTg4NjEtODE4NjVkZWE2YzAzIiwiZXhwIjoxNzQ2MDgzMjcxLCJpc3MiOiJOZXdBZW9uIiwiYXVkIjoiTmV3QWVvbiJ9.DQzDgTwGwKoz3ed56LxTu17WbMcatcL36n6U6Nkb1qQ"
    var acceptLanguage = "2"
    var villaId = "40"

    var banners by mutableStateOf<List<BannerDateModel?>?>(emptyList())

    init {
        getBanners(authorization,acceptLanguage,villaId)
    }


    fun getBanners(authorization: String, acceptLanguage: String, villaId: String){

        viewModelScope.launch {
            val bannerResult = bannerRepository.getBanners(authorization = authorization, acceptLanguage= acceptLanguage, villaId=villaId)

            when(bannerResult){
                is Resource.Success -> {
                    banners = bannerResult.data
                }

                is Resource.Error -> {
                    bannerResult.message
                }

                else -> {}
            }
        }

    }









}