package com.joaoovf.bankuish.domain.repository

import com.joaoovf.bankuish.domain.model.Project

interface ProjectRepoistory {

	suspend fun fetchAll(
		query: String?,
		perPage: Int,
		page: Int
	): List<Project>

}