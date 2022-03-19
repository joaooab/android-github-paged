package com.joaoovf.bankuish.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.joaoovf.bankuish.databinding.ItemProjectBinding
import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.extensions.loadImage

class ListAdapter(private val onClick: (show: Project) -> Unit) :
	PagingDataAdapter<Project, ListAdapter.ViewHolder>(ProjectComparator()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		val binding = ItemProjectBinding.inflate(layoutInflater, parent, false)
		return ViewHolder(binding)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		getItem(position)?.let {
			holder.bind(it)
		}
	}

	inner class ViewHolder(private val binding: ItemProjectBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(project: Project) {
			binding.apply {
				textName.text = project.name
				image.loadImage(project.owner?.avatarUrl)
				textOwnerName.text = project.owner?.login.orEmpty()
				root.setOnClickListener {
					onClick(project)
				}
			}
		}
	}
}

class ProjectComparator : DiffUtil.ItemCallback<Project>() {
	override fun areItemsTheSame(oldItem: Project, newItem: Project): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: Project, newItem: Project): Boolean {
		return oldItem == newItem
	}
}