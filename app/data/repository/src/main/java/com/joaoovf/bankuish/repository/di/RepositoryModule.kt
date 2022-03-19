package com.joaoovf.bankuish.repository.di

import com.joaoovf.bankuish.domain.repository.ProjectRepoistory
import com.joaoovf.bankuish.repository.ProjectRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
	single<ProjectRepoistory> { ProjectRepositoryImpl(get()) }
}