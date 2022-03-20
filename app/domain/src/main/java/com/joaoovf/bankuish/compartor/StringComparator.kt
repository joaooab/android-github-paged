package com.joaoovf.bankuish.compartor

import androidx.recyclerview.widget.DiffUtil

class StringComparator : DiffUtil.ItemCallback<String>() {
	override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
		return oldItem == newItem
	}

	override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
		return oldItem == newItem
	}
}