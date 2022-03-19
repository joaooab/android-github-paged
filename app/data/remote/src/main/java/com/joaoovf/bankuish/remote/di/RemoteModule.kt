package com.joaoovf.bankuish.remote.di

import com.joaoovf.bankuish.remote.AppService
import com.joaoovf.bankuish.remote.ProjectAPI
import org.koin.dsl.module

val remoteModule = module {
	single { AppService.create<ProjectAPI>() }
}