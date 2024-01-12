package com.yusufarisoy.atlastekcase.domain.mapper

import com.yusufarisoy.atlastekcase.core.Mapper
import com.yusufarisoy.atlastekcase.data.entity.CharacterApiModel
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel
import javax.inject.Inject

class CharacterApiModelToDomainModelMapper @Inject constructor() :
    Mapper<CharacterApiModel, CharacterDomainModel> {

    override fun map(input: CharacterApiModel): CharacterDomainModel {
        return CharacterDomainModel(
            id = input.id,
            name = input.name,
            image = input.image,
            gender = input.gender,
            status = input.status,
            species = input.species,
            createdAt = input.created,
            episodes = input.episode
        )
    }
}
