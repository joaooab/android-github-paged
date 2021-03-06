package com.joaoovf.bankuish.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppService {

	private fun createClient(): OkHttpClient {
		val httpLoggingInterceptor = HttpLoggingInterceptor()
		httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
		return OkHttpClient.Builder()
			.addInterceptor(httpLoggingInterceptor)
			.connectTimeout(5, TimeUnit.SECONDS)
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.build()
	}

	val service = Retrofit.Builder()
		.baseUrl("https://api.github.com/")
		.client(createClient())
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	inline fun <reified T> create(): T = service.create(T::class.java)

}