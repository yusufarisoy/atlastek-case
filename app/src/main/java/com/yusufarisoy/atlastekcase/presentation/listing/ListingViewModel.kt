package com.yusufarisoy.atlastekcase.presentation.listing

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.yusufarisoy.atlastekcase.core.BaseViewModel
import com.yusufarisoy.atlastekcase.data.repository.CharacterPagingSource
import com.yusufarisoy.atlastekcase.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {

    val pagerLiveData = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE
        ),
        initialKey = INITIAL_PAGE,
        pagingSourceFactory = {
            CharacterPagingSource(repository)
        }
    ).liveData.cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE = 20
        private const val PREFETCH_DISTANCE = 4
        private const val INITIAL_PAGE = 0
    }
}
