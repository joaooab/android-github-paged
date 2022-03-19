package com.joaoovf.bankuish.domain.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.joaoovf.bankuish.domain.model.Project

class ShowListSource(
	private val fetch: suspend (position: Int) -> List<Project>,
) : PagingSource<Int, Project>() {

	override fun getRefreshKey(state: PagingState<Int, Project>): Int? {
		return state.anchorPosition?.let { anchorPosition ->
			state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
				?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
		}
	}

	override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Project> {
		val position = params.key ?: STARTING_PAGE_INDEX
		return try {
			val data = fetch(position)
			val nextKey = position + (params.loadSize / PAGE_SIZE)
			LoadResult.Page(
				data = data,
				prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
				nextKey = nextKey
			)
		} catch (e: Exception) {
			LoadResult.Error(e)
		}
	}

	companion object {
		private const val STARTING_PAGE_INDEX = 1
		const val PAGE_SIZE = 30
	}

}