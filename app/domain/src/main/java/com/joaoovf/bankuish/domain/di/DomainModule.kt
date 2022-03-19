package com.joaoovf.bankuish.domain.di

import com.joaoovf.bankuish.domain.interactor.LoadPagedUseCase
import com.joaoovf.bankuish.domain.interactor.LoadPagedUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
	factory<LoadPagedUseCase> { LoadPagedUseCaseImpl(get()) }
}

