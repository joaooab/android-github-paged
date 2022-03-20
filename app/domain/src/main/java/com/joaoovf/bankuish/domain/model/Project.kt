package com.joaoovf.bankuish.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Project(
	val id: Int?,
	val name: String,
	val description: String,
	val topics: List<String>,
	val stargazersCount: Int,
	val forksCount: Int,
	val watchersCount: Int,
	val contributorsUrl: String?,
	val languagesUrl: String?,
	val owner: Owner?,
): Parcelable
