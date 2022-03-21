package com.joaoovf.bankuish.domain.repository

import com.joaoovf.bankuish.domain.model.Contributor
import com.joaoovf.bankuish.domain.model.Language
import com.joaoovf.bankuish.domain.model.Project

class FakeProjectRepository(
	private val fakeProjectList: MutableList<Project> = mutableListOf(),
	private val fakeLanguageList: MutableList<Language> = mutableListOf(),
	private val fakeContributorsList: MutableList<Contributor> = mutableListOf(),
) : ProjectRepoistory {

	var isError: Boolean = false

	override suspend fun fetchAll(query: String?, perPage: Int, page: Int): List<Project> {
		if (isError) throw Exception()
		return fakeProjectList
	}

	override suspend fun fetchLanguages(url: String): List<Language> {
		if (isError) throw Exception()
		return fakeLanguageList
	}

	override suspend fun fetchContributors(url: String): List<Contributor> {
		if (isError) throw Exception()
		return fakeContributorsList
	}

}