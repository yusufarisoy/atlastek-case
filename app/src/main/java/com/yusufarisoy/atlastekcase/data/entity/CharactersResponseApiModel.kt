package com.yusufarisoy.atlastekcase.data.entity

import com.google.gson.annotations.SerializedName

data class CharactersResponseApiModel(
    @SerializedName("info") val info: InfoApiModel,
    @SerializedName("results") val items: List<CharacterApiModel>
)
