package com.joaoovf.bankuish.ui.list

import androidx.lifecycle.ViewModel
import com.joaoovf.bankuish.domain.interactor.LoadPagedUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class ListViewModel(
	loadPagedUseCase: LoadPagedUseCase,
	dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

	val pagingData = loadPagedUseCase(query = DEFAULT_QUERY)
		.flow
		.flowOn(dispatcher)

	companion object {
		private const val DEFAULT_QUERY = "kotlin"
	}
}