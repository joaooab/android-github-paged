package com.joaoovf.bankuish.remote.model

import com.google.gson.annotations.SerializedName

class ProjectNewtork(
	@SerializedName("id")
	val id: Int?,
	@SerializedName("name")
	val name: String?,
	@SerializedName("description")
	val description: String?,
	@SerializedName("contributors_url")
	val contributorsUrl: String?,
	@SerializedName("languages_url")
	val languagesUrl: String?,
	@SerializedName("forks_count")
	val forksCount: Int?,
	@SerializedName("watchers_count")
	val watchersCount: Int?,
	@SerializedName("stargazers_count")
	val stargazersCount: Int?,
	@SerializedName("topics")
	val topics: List<String>?,
	@SerializedName("owner")
	val ownerNewtork: OwnerNewtork?
)