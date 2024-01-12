package com.yusufarisoy.atlastekcase.data.repository

import com.yusufarisoy.atlastekcase.core.networkCall
import com.yusufarisoy.atlastekcase.data.api.RickAndMortyApi
import com.yusufarisoy.atlastekcase.domain.mapper.CharacterApiModelToDomainModelMapper
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi,
    private val mapper: CharacterApiModelToDomainModelMapper
) : CharacterRepository {

    override suspend fun getCharacters(page: Int): List<CharacterDomainModel> {
        val response = networkCall { api.getCharacters(page) }

        return response.items.map(mapper::map)
    }

    override suspend fun getCharacterById(id: Int): CharacterDomainModel {
        val response = networkCall { api.getCharacterById(id) }

        return mapper.map(response)
    }
}
