package com.joaoovf.bankuish.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Project(
	val id: Int? = null,
	val name: String = "",
	val description: String = "",
	val topics: List<String> = listOf(),
	val stargazersCount: Int = 0,
	val forksCount: Int = 0,
	val watchersCount: Int = 0,
	val contributorsUrl: String? = null,
	val languagesUrl: String? = null,
	val owner: Owner? = null,
) : Parcelable
