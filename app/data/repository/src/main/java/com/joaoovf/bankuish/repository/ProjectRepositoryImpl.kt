package com.joaoovf.bankuish.repository

import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import com.joaoovf.bankuish.remote.ProjectAPI
import com.joaoovf.bankuish.repository.mapper.mapFromNetwork
import com.joaoovf.bankuish.repository.mapper.toModel

class ProjectRepositoryImpl(private val api: ProjectAPI) : ProjectRepoistory {

	override suspend fun fetchAll(
		query: String?,
		perPage: Int,
		page: Int
	): List<Project> {
		return api.fetchAll(
			query,
			perPage,
			page
		).items.mapFromNetwork {
			toModel()
		}
	}

}