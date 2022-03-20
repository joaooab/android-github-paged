package com.joaoovf.bankuish.repository.mapper

import com.joaoovf.bankuish.domain.model.Contributor
import com.joaoovf.bankuish.remote.model.ContributorNetwork

fun ContributorNetwork.toModel() = Contributor(
	avatarUrl = avatarUrl
)