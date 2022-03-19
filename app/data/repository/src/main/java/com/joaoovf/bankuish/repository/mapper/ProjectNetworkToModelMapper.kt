package com.joaoovf.bankuish.repository.mapper

import com.joaoovf.bankuish.domain.model.Owner
import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.remote.model.OwnerNewtork
import com.joaoovf.bankuish.remote.model.ProjectNewtork

fun ProjectNewtork.toModel() = Project(
	id = id,
	name = name.orEmpty(),
	description = description.orEmpty(),
	topics = topics.orEmpty(),
	stargazersCount = stargazersCount ?: 0,
	forksCount = forksCount ?: 0,
	watchersCount = watchersCount ?: 0,
	contributorsUrl = contributorsUrl,
	languagesUrl = languagesUrl,
	owner = ownerNewtork?.toModel()
)

fun OwnerNewtork.toModel() = Owner(
	id = id,
	login = login.orEmpty(),
	type = type.orEmpty(),
	avatarUrl = avatarUrl
)