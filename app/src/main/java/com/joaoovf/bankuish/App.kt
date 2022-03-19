package com.joaoovf.bankuish

import android.app.Application
import com.joaoovf.bankuish.di.uiModule
import com.joaoovf.bankuish.domain.di.domainModule
import com.joaoovf.bankuish.remote.di.remoteModule
import com.joaoovf.bankuish.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@App)
			modules(
				listOf(
					domainModule,
					repositoryModule,
					remoteModule,
					uiModule,
				)
			)
		}
	}
}