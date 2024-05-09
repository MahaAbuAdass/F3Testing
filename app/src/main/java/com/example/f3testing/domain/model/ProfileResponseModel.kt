package com.example.f3testing.domain.model

import com.google.gson.annotations.SerializedName

data class ProfileResponseModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("villaNumber")
    val villaNumber: String?
)