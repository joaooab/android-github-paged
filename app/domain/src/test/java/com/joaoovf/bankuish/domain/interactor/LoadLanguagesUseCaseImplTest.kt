package com.joaoovf.bankuish.domain.interactor

import com.joaoovf.bankuish.domain.MainCoroutineRule
import com.joaoovf.bankuish.domain.State
import com.joaoovf.bankuish.domain.model.Language
import com.joaoovf.bankuish.domain.repository.FakeProjectRepository
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoadLanguagesUseCaseImplTest {

	@get:Rule
	var mainCoroutineRule = MainCoroutineRule()

	private lateinit var fakeLanguageList: MutableList<Language>
	private lateinit var fakeRepository: FakeProjectRepository
	private lateinit var loadLanguagesUseCaseImpl: LoadLanguagesUseCaseImpl

	@Before
	fun setup() {
		fakeLanguageList = createFakeList()
		fakeRepository = FakeProjectRepository(fakeLanguageList = fakeLanguageList)
		loadLanguagesUseCaseImpl = LoadLanguagesUseCaseImpl(fakeRepository)
	}

	@Test
	fun `Given a url When load languages Then return states loading and success`() = runTest {
		//Given
		val url = "url"

		//When
		val states = loadLanguagesUseCaseImpl(url)
			.take(2)
			.toList()

		//Then
		assertThat(states[0], instanceOf(State.Loading::class.java))
		assertThat(states[1], instanceOf(State.Success::class.java))
		assertThat((states[1] as State.Success).data.size, `is`(10))
	}

	@Test
	fun `Given a url When load languages with error Then return states loading and error`() = runTest {
		//Given
		val url = "url"

		//When
		fakeRepository.isError = true
		val states = loadLanguagesUseCaseImpl(url)
			.take(2)
			.toList()

		//Then
		assertThat(states[0], instanceOf(State.Loading::class.java))
		assertThat(states[1], instanceOf(State.Error::class.java))
	}


	private fun createFakeList() = IntRange(0, 9).map { Language() }.toMutableList()

}