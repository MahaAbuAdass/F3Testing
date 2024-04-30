package com.example.f3testing.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.parcelize.IgnoredOnParcel

data class ServicesResponseModel(
    @SerializedName("code") val code: Int?,
    @SerializedName("data") val data: List<ServicesDataModel?>?,
    @SerializedName("error") val error: BaseError?
)



data class ServicesDataModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("enumId") val enumId: Int?,
    @SerializedName("order") val order: Int?,
    @SerializedName("iconImg") val iconImg: String?,
    @SerializedName("title") val title: String?
)



@Parcelize
data class BaseError(
    @SerializedName("errors") val errors: List<String>?,
    @SerializedName("messageEn") val messageEn: String?,
    @SerializedName("messageAr") val messageAr: String?
) : Parcelable {
    @IgnoredOnParcel
    val message: String ?= null

}