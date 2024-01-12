package com.yusufarisoy.atlastekcase.presentation.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusufarisoy.atlastekcase.databinding.RecyclerItemEpisodeBinding

class EpisodesAdapter : RecyclerView.Adapter<EpisodesAdapter.EpisodeViewHolder>() {

    private val episodes: ArrayList<String> = ArrayList()

    fun submitData(items: List<String>) {
        episodes.addAll(items)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    class EpisodeViewHolder(private val binding: RecyclerItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(episode: String) {
            binding.textEpisode.text = episode
        }

        companion object {
            fun from(parent: ViewGroup): EpisodeViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecyclerItemEpisodeBinding.inflate(inflater, parent, false)

                return EpisodeViewHolder(binding)
            }
        }
    }
}
