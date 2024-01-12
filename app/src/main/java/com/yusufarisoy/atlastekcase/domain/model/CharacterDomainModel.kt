package com.yusufarisoy.atlastekcase.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterDomainModel(
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    val status: String,
    val species: String,
    val createdAt: String,
    val episodes: List<String>
) : Parcelable
