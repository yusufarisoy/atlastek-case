package com.yusufarisoy.atlastekcase.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.yusufarisoy.atlastekcase.databinding.FragmentDetailBinding
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var adapter: EpisodesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observeCharacterLiveData()
    }

    private fun initRecycler() {
        adapter = EpisodesAdapter()
        binding.recyclerEpisodes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerEpisodes.adapter = adapter
    }

    private fun observeCharacterLiveData() {
        viewModel.characterLiveData.observe(viewLifecycleOwner) { character ->
            setViews(character)
        }
    }

    private fun setViews(character: CharacterDomainModel) {
        with(binding) {
            Glide.with(requireContext()).load(character.image).into(imageCharacter)
            textName.text = character.name
            textGender.text = character.gender
            textSpecies.text = character.species
            textCreated.text = character.createdAt
            textStatus.text = character.status
            adapter.submitData(character.episodes)
        }
    }

    companion object {
        fun newInstance(character: CharacterDomainModel): DetailFragment {
            val detailFragment = DetailFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_CHARACTER, character)
            detailFragment.arguments = bundle

            return detailFragment
        }

        const val ARG_CHARACTER = "character_detail"
    }
}
