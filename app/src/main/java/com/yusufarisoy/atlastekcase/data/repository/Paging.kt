package com.yusufarisoy.atlastekcase.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel

class CharacterPagingSource(
    private val repository: CharacterRepository
) : PagingSource<Int, CharacterDomainModel>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, CharacterDomainModel> {
        try {
            val nextPage = params.key ?: 0
            val response = repository.getCharacters(nextPage)

            return LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextPage + 1
            )
        } catch (e: Exception) {
            throw Throwable("Error in paging", e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDomainModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
