package com.joaoovf.bankuish.extensions

import android.view.View
import com.google.android.material.textfield.TextInputLayout

fun View.show() {
	this.visibility = View.VISIBLE
}

fun View.hide() {
	this.visibility = View.INVISIBLE

}

fun View.gone() {
	this.visibility = View.GONE

}