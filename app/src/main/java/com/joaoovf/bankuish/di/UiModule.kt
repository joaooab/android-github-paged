package com.joaoovf.bankuish.di

import com.joaoovf.bankuish.ui.detail.DetailViewModel
import com.joaoovf.bankuish.ui.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
	viewModel { ListViewModel(get()) }
	viewModel { DetailViewModel(get(), get()) }
}