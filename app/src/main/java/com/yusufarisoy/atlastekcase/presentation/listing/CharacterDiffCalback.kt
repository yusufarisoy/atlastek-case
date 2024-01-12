package com.yusufarisoy.atlastekcase.presentation.listing

import androidx.recyclerview.widget.DiffUtil
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel

class CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDomainModel>() {

    override fun areItemsTheSame(
        oldItem: CharacterDomainModel,
        newItem: CharacterDomainModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharacterDomainModel,
        newItem: CharacterDomainModel
    ): Boolean {
        return oldItem == newItem
    }

}
