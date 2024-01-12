package com.yusufarisoy.atlastekcase.data.entity

import com.google.gson.annotations.SerializedName

data class OriginApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
