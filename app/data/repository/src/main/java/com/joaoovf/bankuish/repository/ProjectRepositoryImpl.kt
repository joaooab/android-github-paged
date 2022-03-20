package com.joaoovf.bankuish.repository

import com.joaoovf.bankuish.domain.model.Contributor
import com.joaoovf.bankuish.domain.model.Language
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

	override suspend fun fetchLanguages(url: String): List<Language> {
		return api.fetchLanguages(url).mapNotNull {
			val key = it.key
			val value = it.value
			if (key == null || value == null) null
			else Language(key, value)
		}
	}

	override suspend fun fetchContributors(url: String): List<Contributor> {
		return api.fetchContributors(url).mapFromNetwork { toModel() }
	}

}