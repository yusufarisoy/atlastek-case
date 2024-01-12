package com.yusufarisoy.atlastekcase.data.repository

import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel

interface CharacterRepository {

    suspend fun getCharacters(
        page: Int
    ): List<CharacterDomainModel>

    suspend fun getCharacterById(id: Int): CharacterDomainModel
}
