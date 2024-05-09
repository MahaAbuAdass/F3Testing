package com.example.f3testing.presentation.servicesscreen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f3testing.domain.model.ProfileResponseModel
import com.example.f3testing.domain.repository.F3Repository
import com.example.f3testing.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetUserProfileDataViewModel @Inject constructor(private val userProfileRepository : F3Repository) : ViewModel() {

    var authorization =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJ0ZXN0OTBAZ21haWwuY29tIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvc2lkIjoiYjQ0NjQwODYtN2IwNy00MjU1LTg4NjEtODE4NjVkZWE2YzAzIiwiZXhwIjoxNzQ2MDgzMjcxLCJpc3MiOiJOZXdBZW9uIiwiYXVkIjoiTmV3QWVvbiJ9.DQzDgTwGwKoz3ed56LxTu17WbMcatcL36n6U6Nkb1qQ"
    var acceptLanguage = "2"
    var villaId = "40"

    val date = ProfileResponseModel(
        "test",
        "test" ,
       "test"
    )
    var userData by mutableStateOf<ProfileResponseModel>(date)


    init {
        getUserData(authorization, acceptLanguage, villaId)
    }

    private fun getUserData(authorization: String, acceptLanguage: String, villaId: String){
        viewModelScope.launch {
            val userProfileData = userProfileRepository.getUserProfile(authorization = authorization, acceptLanguage= acceptLanguage, villaId=villaId)

            when(userProfileData){
                is Resource.Success -> {
                    userData = userProfileData.data!!
                    Log.v("user data view", userData.toString())

                }

                is Resource.Error-> {
                    userProfileData.message
                }
            }
        }
    }
}