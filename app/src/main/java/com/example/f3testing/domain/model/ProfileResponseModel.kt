package com.example.f3testing.domain.model

import com.google.gson.annotations.SerializedName



data class UserInfo(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: ProfileResponseModel,
    @SerializedName("error") val error: BaseError?
)
data class ProfileResponseModel(
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("villaNumber")
    val villaNumber: String?
)