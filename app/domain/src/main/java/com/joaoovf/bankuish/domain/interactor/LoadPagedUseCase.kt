package com.joaoovf.bankuish.domain.interactor

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import com.joaoovf.bankuish.domain.source.ProjectListSource

interface LoadPagedUseCase {

	operator fun invoke(query: String?): Pager<Int, Project>

}

class LoadPagedUseCaseImpl(
	private val repository: ProjectRepoistory,
) : LoadPagedUseCase {

	override fun invoke(query: String?): Pager<Int, Project> {
		return Pager(
			PagingConfig(pageSize = ProjectListSource.PAGE_SIZE),
		) {
			ProjectListSource { page ->
				repository.fetchAll(
					query,
					ProjectListSource.PAGE_SIZE,
					page
				)
			}
		}
	}

}