package com.joaoovf.bankuish.domain.interactor

import com.joaoovf.bankuish.domain.State
import com.joaoovf.bankuish.domain.model.Language
import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface LoadLanguagesUseCase {

	operator fun invoke(url: String?): Flow<State<List<Language>>>

}

class LoadLanguagesUseCaseImpl(private val repoistory: ProjectRepoistory) : LoadLanguagesUseCase {

	override fun invoke(url: String?) = flow<State<List<Language>>> {
		emit(State.Loading())
		runCatching {
			if (url.isNullOrEmpty()) throw IllegalArgumentException()
			repoistory.fetchLanguages(url)
		}.onSuccess { list ->
			emit(State.Success(list.sortedByDescending { it.value }))
		}.onFailure {
			emit(State.Error(it))
		}
	}

}