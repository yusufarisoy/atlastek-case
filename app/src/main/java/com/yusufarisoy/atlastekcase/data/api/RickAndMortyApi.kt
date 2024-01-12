package com.yusufarisoy.atlastekcase.data.api

import com.yusufarisoy.atlastekcase.data.entity.CharacterApiModel
import com.yusufarisoy.atlastekcase.data.entity.CharactersResponseApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET(Endpoints.GET_CHARACTERS)
    suspend fun getCharacters(
        @Query(Queries.PAGE) page: Int
    ): Response<CharactersResponseApiModel>

    @GET(Endpoints.GET_CHARACTER_BY_ID)
    suspend fun getCharacterById(@Path(Paths.ID) id: Int): Response<CharacterApiModel>

    companion object {
        private object Endpoints {
            const val GET_CHARACTERS = "character"
            const val GET_CHARACTER_BY_ID = "character/{id}"
        }

        private object Queries {
            const val PAGE = "page"
        }

        private object Paths {
            const val ID = "id"
        }
    }
}
