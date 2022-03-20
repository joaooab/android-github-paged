package com.joaoovf.bankuish.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
	val id: Int?,
	val login: String,
	val type: String,
	val avatarUrl: String?,
) : Parcelable