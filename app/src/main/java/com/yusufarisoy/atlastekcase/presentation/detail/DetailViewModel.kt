package com.yusufarisoy.atlastekcase.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.yusufarisoy.atlastekcase.core.BaseViewModel
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _characterLiveData: MutableLiveData<CharacterDomainModel> = MutableLiveData()
    val characterLiveData: LiveData<CharacterDomainModel>
        get() = _characterLiveData

    init {
        getCharacter()
    }

    private fun getCharacter() {
        val character = savedStateHandle.get<CharacterDomainModel>(DetailFragment.ARG_CHARACTER)
        character?.let {
            _characterLiveData.value = it
        }
    }
}
