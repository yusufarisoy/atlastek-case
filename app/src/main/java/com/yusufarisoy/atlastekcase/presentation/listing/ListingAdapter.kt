package com.yusufarisoy.atlastekcase.presentation.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusufarisoy.atlastekcase.databinding.RecyclerItemCharacterBinding
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel

class ListingAdapter(
    diffCallback: CharacterDiffCallback,
    private val onCharacterClicked: (CharacterDomainModel) -> Unit
) : PagingDataAdapter<CharacterDomainModel, ListingAdapter.CharacterViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.bind(character, onCharacterClicked)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.from(parent)
    }

    class CharacterViewHolder(
        private val binding: RecyclerItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: CharacterDomainModel, onClicked: (CharacterDomainModel) -> Unit) {
            Glide.with(binding.root).load(character.image).into(binding.imageCharacter)
            binding.textName.text = character.name

            binding.itemLayout.setOnClickListener {
                onClicked(character)
            }
        }

        companion object {
            fun from(parent: ViewGroup): CharacterViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerItemCharacterBinding.inflate(inflater, parent, false)

                return CharacterViewHolder(binding)
            }
        }
    }
}
