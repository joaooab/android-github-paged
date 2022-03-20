package com.joaoovf.bankuish.domain.interactor

import com.joaoovf.bankuish.domain.State
import com.joaoovf.bankuish.domain.model.Contributor
import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface LoadContributorsUseCase {

	operator fun invoke(url: String?): Flow<State<List<Contributor>>>

}

class LoadContributorsUseCaseImpl(private val repoistory: ProjectRepoistory) : LoadContributorsUseCase {

	override fun invoke(url: String?) = flow<State<List<Contributor>>> {
		emit(State.Loading())
		runCatching {
			if (url.isNullOrEmpty()) throw IllegalArgumentException()
			repoistory.fetchContributors(url)
		}.onSuccess { list ->
			emit(State.Success(list))
		}.onFailure {
			emit(State.Error(it))
		}
	}

}