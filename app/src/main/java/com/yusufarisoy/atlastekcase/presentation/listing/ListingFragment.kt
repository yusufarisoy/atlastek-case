package com.yusufarisoy.atlastekcase.presentation.listing

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.yusufarisoy.atlastekcase.R
import com.yusufarisoy.atlastekcase.databinding.FragmentListingBinding
import com.yusufarisoy.atlastekcase.domain.model.CharacterDomainModel
import com.yusufarisoy.atlastekcase.presentation.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListingFragment : Fragment() {

    private val viewModel: ListingViewModel by viewModels()
    private lateinit var binding: FragmentListingBinding
    private lateinit var adapter: ListingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeCharactersLiveData()
    }

    private fun initRecyclerView() {
        adapter = ListingAdapter(
            diffCallback = CharacterDiffCallback(),
            onCharacterClicked = ::navigateToDetail
        )
        val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LANDSCAPE_SPAN_COUNT
        } else {
            PORTRAIT_SPAN_COUNT
        }
        binding.recyclerListing.layoutManager = StaggeredGridLayoutManager(
            spanCount,
            LinearLayoutManager.VERTICAL
        )
        binding.recyclerListing.adapter = adapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        initRecyclerView()
    }

    private fun observeCharactersLiveData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pagerLiveData.observe(viewLifecycleOwner) { characters ->
                adapter.submitData(lifecycle, characters)
            }
        }
    }

    private fun navigateToDetail(character: CharacterDomainModel) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, DetailFragment.newInstance(character))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        binding.recyclerListing.adapter = null
        super.onDestroy()
    }

    companion object {
        fun newInstance() = ListingFragment()

        private const val PORTRAIT_SPAN_COUNT = 2
        private const val LANDSCAPE_SPAN_COUNT = 3
    }
}
