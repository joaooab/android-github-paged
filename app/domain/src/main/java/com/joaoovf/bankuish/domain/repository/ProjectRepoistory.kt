package com.joaoovf.bankuish.domain.repository

import com.joaoovf.bankuish.domain.model.Contributor
import com.joaoovf.bankuish.domain.model.Language
import com.joaoovf.bankuish.domain.model.Project

interface ProjectRepoistory {

	suspend fun fetchAll(
		query: String?,
		perPage: Int,
		page: Int
	): List<Project>

	suspend fun fetchLanguages(url: String): List<Language>

	suspend fun fetchContributors(url: String): List<Contributor>

}