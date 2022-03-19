package com.joaoovf.bankuish.remote.model

import com.google.gson.annotations.SerializedName

class ProjectResultNetwork(
	@SerializedName("items")
	val items: List<ProjectNewtork>?
)