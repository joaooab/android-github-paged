package com.joaoovf.bankuish.remote

import com.joaoovf.bankuish.remote.model.ContributorNetwork
import com.joaoovf.bankuish.remote.model.ProjectResultNetwork
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ProjectAPI {

	@GET("/search/repositories")
	suspend fun fetchAll(
		@Query("q") query: String?,
		@Query("per_page") perPage: Int,
		@Query("page") page: Int
	): ProjectResultNetwork

	@GET
	suspend fun fetchLanguages(@Url url: String): Map<String?, Int?>

	@GET
	suspend fun fetchContributors(@Url url: String): List<ContributorNetwork>

}