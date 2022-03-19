package com.joaoovf.bankuish.extensions

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.joaoovf.bankuish.R

fun ImageView.loadImage(imagePath: String?) {
	if (imagePath.isNullOrEmpty()) {
		this.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_placeholder))
	} else {
		val uri = imagePath.toUri().buildUpon().scheme("https").build()
		Glide.with(context)
			.load(uri)
			.apply(
				RequestOptions()
					.placeholder(R.drawable.ic_placeholder)
					.error(R.drawable.ic_placeholder_error)
			)
			.into(this)
	}

}