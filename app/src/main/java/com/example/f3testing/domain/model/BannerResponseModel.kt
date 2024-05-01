package com.example.f3testing.domain.model

import com.google.gson.annotations.SerializedName

data class BannerDateModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("desc") val desc: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("image") val image: String?
)


data class BannerResponseModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: List<BannerDateModel?>?,
    @SerializedName("error") val error: BaseError?
)