package com.joaoovf.bankuish

import androidx.test.filters.LargeTest
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertListNotEmpty
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertContains
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaListInteractions.clickListItem
import com.adevinta.android.barista.interaction.BaristaSleepInteractions.sleep
import com.adevinta.android.barista.rule.BaristaRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class DetailProjectTest {

	@get:Rule
	var rule = BaristaRule.create(MainActivity::class.java)

	@Before
	fun before() {
		rule.launchActivity()
	}

	@After
	fun after() {
		rule.activityTestRule.finishActivity()
	}

	@Test
	fun init() {
		assertDisplayed(R.id.list)
		sleep(4000)
		assertListNotEmpty(R.id.list)
		clickListItem(R.id.list, 0)
		sleep(4000)
		assertContains(R.id.textName, "kotlin")
		assertContains(R.id.textOwnerName, "JetBrains")
		assertListNotEmpty(R.id.listLanguage)
		assertListNotEmpty(R.id.listContributors)
	}

}
