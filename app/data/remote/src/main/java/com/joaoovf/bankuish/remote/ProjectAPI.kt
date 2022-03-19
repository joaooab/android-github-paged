package com.joaoovf.bankuish.remote

import com.joaoovf.bankuish.remote.model.ProjectResultNetwork
import retrofit2.http.GET
import retrofit2.http.Query

interface ProjectAPI {

	@GET("/search/repositories")
	suspend fun fetchAll(
		@Query("q") query: String?,
		@Query("per_page") perPage: Int,
		@Query("page") page: Int
	): ProjectResultNetwork

}