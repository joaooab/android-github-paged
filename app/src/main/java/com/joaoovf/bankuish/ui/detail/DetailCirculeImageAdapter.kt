package com.joaoovf.bankuish.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.joaoovf.bankuish.compartor.StringComparator
import com.joaoovf.bankuish.databinding.ItemCircleImageBinding
import com.joaoovf.bankuish.extensions.loadImage

class DetailCirculeImageAdapter :
	ListAdapter<String, DetailCirculeImageAdapter.ViewHolder>(StringComparator()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = ItemCircleImageBinding.inflate(layoutInflater, parent, false)
		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		getItem(position)?.let {
			holder.bind(it)
		}
	}

	inner class ViewHolder(private val binding: ItemCircleImageBinding) :
		RecyclerView.ViewHolder(binding.root) {

		fun bind(url: String) {
			binding.image.loadImage(url)
		}
	}

}

