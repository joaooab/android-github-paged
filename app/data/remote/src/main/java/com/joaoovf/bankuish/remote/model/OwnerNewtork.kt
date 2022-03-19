package com.joaoovf.bankuish.remote.model

import com.google.gson.annotations.SerializedName

class OwnerNewtork(
	@SerializedName("id")
	val id: Int?,
	@SerializedName("login")
	val login: String?,
	@SerializedName("type")
	val type: String?,
	@SerializedName("avatar_url")
	val avatarUrl: String?,
)