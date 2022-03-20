package com.joaoovf.bankuish.domain.di

import com.joaoovf.bankuish.domain.interactor.*
import org.koin.dsl.module

val domainModule = module {
	factory<LoadPagedUseCase> { LoadPagedUseCaseImpl(get()) }
	factory<LoadLanguagesUseCase> { LoadLanguagesUseCaseImpl(get()) }
	factory<LoadContributorsUseCase> { LoadContributorsUseCaseImpl(get()) }
}

