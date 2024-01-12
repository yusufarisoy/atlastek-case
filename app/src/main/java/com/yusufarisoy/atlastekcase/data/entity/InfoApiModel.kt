package com.yusufarisoy.atlastekcase.data.entity

import com.google.gson.annotations.SerializedName

data class InfoApiModel(
    @SerializedName("count") val count: Int,
    @SerializedName("pages") val pages: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("prev") val prev: String?
)
