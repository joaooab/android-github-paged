package com.joaoovf.bankuish.domain.interactor

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import com.joaoovf.bankuish.domain.source.ShowListSource

interface LoadPagedUseCase {

	operator fun invoke(query: String?): Pager<Int, Project>

}

class LoadPagedUseCaseImpl(
	private val repository: ProjectRepoistory,
) : LoadPagedUseCase {

	override fun invoke(query: String?): Pager<Int, Project> {
		return Pager(
			PagingConfig(pageSize = ShowListSource.PAGE_SIZE),
		) {
			ShowListSource { page ->
				repository.fetchAll(
					query,
					ShowListSource.PAGE_SIZE,
					page
				)
			}
		}
	}

}