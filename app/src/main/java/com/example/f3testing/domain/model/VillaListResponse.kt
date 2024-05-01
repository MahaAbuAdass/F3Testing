package com.example.f3testing.domain.model

import com.google.gson.annotations.SerializedName


data class VillaListResponse(
    @SerializedName("code")  val code: Int,
    @SerializedName("data")  val data: List<VillaDetails>,
    @SerializedName("error")val error: BaseError?
)
data class VillaDetails(
    @SerializedName("villaId")val villaId: Int?,
    @SerializedName("villaNumber")val villaNumber: String?
)



