package com.example.f3testing.presentation.servicesscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f3testing.domain.model.ServicesDataModel
import com.example.f3testing.domain.repository.F3Repository
import com.example.f3testing.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GetServicesViewModel @Inject constructor(private val f3Repository: F3Repository) :
    ViewModel() {

    var authorization =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9lbWFpbGFkZHJlc3MiOiJUZXN0MkBnbWFpbC5jb20iLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiJiZTA3NWVmOC1jYTU0LTQ5YTQtYWNmZi02MTkyMTI3MzlkZTciLCJleHAiOjE3MDkzNzk1MTEsImlzcyI6Ik5ld0Flb24iLCJhdWQiOiJOZXdBZW9uIn0.lXPZsH3xLpqbjh7l9JhYe115kE6RitRhfxf6V-gSESY"
    var acceptLanguage = "1"
    var villaId = "40"

    var services by mutableStateOf<List<ServicesDataModel>>(emptyList())


    init {
        getAllServices(authorization, acceptLanguage, villaId)
    }


    private fun getAllServices(authorization: String, acceptLanguage: String, villaId: String) {

        viewModelScope.launch {
            var result = f3Repository.getAllServices(
                authorization = authorization,
                acceptLanguage = acceptLanguage,
                villaId = villaId
            )

            when (result) {
                is Resource.Success -> {
                    services = (result.data ?: emptyList()) as List<ServicesDataModel>
                    Log.v("services list", services.toString())

                }

                is Resource.Error -> {
                    result.message.toString()
                }

                else -> {
                }
            }
        }
    }

}