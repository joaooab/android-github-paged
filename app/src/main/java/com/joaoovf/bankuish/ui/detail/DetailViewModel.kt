package com.joaoovf.bankuish.ui.detail

import androidx.lifecycle.ViewModel
import com.joaoovf.bankuish.domain.interactor.LoadContributorsUseCase
import com.joaoovf.bankuish.domain.interactor.LoadLanguagesUseCase

class DetailViewModel(
	private val loadLanguagesUseCase: LoadLanguagesUseCase,
	private val loadContributorsUseCase: LoadContributorsUseCase
) : ViewModel() {

	fun fetchLanguages(url: String?) = loadLanguagesUseCase(url)

	fun fetchContributors(url: String?) = loadContributorsUseCase(url)
}