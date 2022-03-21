package com.joaoovf.bankuish.domain.interactor

import androidx.paging.PagingSource
import com.joaoovf.bankuish.domain.MainCoroutineRule
import com.joaoovf.bankuish.domain.model.Project
import com.joaoovf.bankuish.domain.repository.FakeProjectRepository
import com.joaoovf.bankuish.domain.source.ProjectListSource
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoadPagedUseCaseImplTest {

	@get:Rule
	var mainCoroutineRule = MainCoroutineRule()

	private lateinit var fakeProjectList: MutableList<Project>
	private lateinit var fakeRepository: FakeProjectRepository
	private lateinit var pagingSource: ProjectListSource

	@Before
	fun setup() {
		fakeProjectList = mutableListOf()
		fakeRepository = FakeProjectRepository(fakeProjectList)
		pagingSource = ProjectListSource { position ->
			fakeRepository.fetchAll(null, ProjectListSource.PAGE_SIZE, position)
		}
	}

	@Test
	fun `Given page size 30 When load Then return first page`() = runTest {
		//Given
		fakeProjectList.addAll(createFakeList(30))

		//When
		val load = pagingSource.load(
			PagingSource.LoadParams.Refresh(
				key = null,
				loadSize = 30,
				placeholdersEnabled = false
			)
		)

		val expected = PagingSource.LoadResult.Page(
			data = fakeProjectList,
			prevKey = null,
			nextKey = 1
		)

		//Then
		assertThat(load, `is`(expected))
	}

	@Test
	fun `Given page size 60 When load Then return second page`() = runTest {
		//Given
		fakeProjectList.addAll(createFakeList(60))

		//When
		val load = pagingSource.load(
			PagingSource.LoadParams.Refresh(
				key = null,
				loadSize = 60,
				placeholdersEnabled = false
			)
		)

		val expected = PagingSource.LoadResult.Page(
			data = fakeProjectList,
			prevKey = null,
			nextKey = 2
		)

		//Then
		assertThat(load, `is`(expected))
	}

	private fun createFakeList(limit: Int) = IntRange(0, limit - 1).map { Project(it, "name$it") }.toMutableList()

}