package com.yusufarisoy.atlastekcase.data.entity

import com.google.gson.annotations.SerializedName

data class LocationApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
