package com.joaoovf.bankuish.ui.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.google.android.material.snackbar.Snackbar
import com.joaoovf.bankuish.R
import com.joaoovf.bankuish.base.BaseFragment
import com.joaoovf.bankuish.databinding.FragmentListBinding
import com.joaoovf.bankuish.extensions.gone
import com.joaoovf.bankuish.extensions.safeFlowCollect
import com.joaoovf.bankuish.extensions.show
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

	private val viewModel: ListViewModel by viewModel()
	private val adapter = ListAdapter {
		findNavController().navigate(
			ListFragmentDirections.actionNavigationListToDetailFragment(it)
		)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupView()
	}

	private fun setupView() {
		binding.list.adapter = adapter
		collectPagingData()
		collectStateAdapter()
	}

	private fun collectStateAdapter() = safeFlowCollect {
		adapter.loadStateFlow.collectLatest { state ->
			when (state.source.refresh) {
				is LoadState.Loading -> {
					binding.apply {
						loading.show()
						list.gone()
						includeEmpty.root.gone()
					}
				}
				is LoadState.Error -> {
					binding.apply {
						loading.gone()
						showList(state)
					}
					showLoadingStateError()
				}
				else -> {
					binding.apply {
						loading.gone()
						showList(state)
					}
				}
			}
		}
	}

	private fun FragmentListBinding.showList(state: CombinedLoadStates) {
		if (isEmptyResult(state)) {
			list.gone()
			includeEmpty.root.show()
		} else {
			list.show()
			includeEmpty.root.gone()
		}
	}

	private fun isEmptyResult(state: CombinedLoadStates) =
		state.refresh is LoadState.NotLoading && adapter.itemCount == 0

	private fun collectPagingData() = safeFlowCollect {
		viewModel.pagingData.collectLatest {
			adapter.submitData(it)
		}
	}

	private fun showLoadingStateError() {
		Snackbar
			.make(
				requireView(),
				getString(R.string.message_paging_error),
				Snackbar.LENGTH_INDEFINITE
			)
			.setAction(R.string.retry) { adapter.retry() }
			.show()
	}

}