package com.joaoovf.bankuish.ui.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.joaoovf.bankuish.base.BaseFragment
import com.joaoovf.bankuish.databinding.FragmentDetailBinding
import com.joaoovf.bankuish.domain.State
import com.joaoovf.bankuish.extensions.*
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

	private val viewModel: DetailViewModel by viewModel()
	private val argument by navArgs<DetailFragmentArgs>()
	private val project by lazy { argument.project }
	private val topicAdapter = DetailShapeTextAdapter()
	private val languageAdapter = DetailShapeTextAdapter()
	private val contributorsAdapter = DetailCirculeImageAdapter()

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setupView()
	}

	private fun setupView() {
		setupIntro()
		setupStatistic()
		setupLanguages()
		setupContributors()
	}

	private fun setupContributors() = safeFlowCollect {
		binding.includeContributors.listContributors.adapter = contributorsAdapter
		viewModel.fetchContributors(project.contributorsUrl).collectLatest { state ->
			when (state) {
				is State.Loading -> {
					binding.includeContributors.apply {
						loadingContributors.show()
						listContributors.hide()
					}
				}
				is State.Success -> {
					binding.includeContributors.apply {
						loadingContributors.gone()
						listContributors.show()
					}
					contributorsAdapter.submitList(
						state.data.map { it.avatarUrl }
					)
				}
				is State.Error -> {
					binding.includeContributors.apply {
						loadingContributors.gone()
						listContributors.show()
					}
				}
			}
		}
	}

	private fun setupLanguages() = safeFlowCollect {
		binding.includeLanguage.listLanguage.adapter = languageAdapter
		viewModel.fetchLanguages(project.languagesUrl).collectLatest { state ->
			when (state) {
				is State.Loading -> {
					binding.includeLanguage.apply {
						loadingLanguage.show()
						listLanguage.hide()
					}
				}
				is State.Success -> {
					binding.includeLanguage.apply {
						loadingLanguage.gone()
						listLanguage.show()
					}
					languageAdapter.submitList(
						state.data.map { it.name }
					)
				}
				is State.Error -> {
					binding.includeLanguage.apply {
						loadingLanguage.gone()
						listLanguage.show()
					}
				}
			}
		}
	}

	private fun setupStatistic() {
		binding.includeStatistic.apply {
			textStar.text = project.stargazersCount.toString()
			textFork.text = project.forksCount.toString()
			textWatch.text = project.watchersCount.toString()
		}
	}

	private fun setupIntro() {
		binding.includeIntro.apply {
			textName.text = project.name
			image.loadImage(project.owner?.avatarUrl)
			textOwnerName.text = project.owner?.login.orEmpty()
			textDescription.text = project.description
			listTopic.adapter = topicAdapter
			topicAdapter.submitList(project.topics)
		}
	}

}