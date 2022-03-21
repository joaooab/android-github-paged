package com.joaoovf.bankuish

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

	private val navController by lazy { findNavController(R.id.nav_host_fragment_activity_main) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setupNavController()
	}

	private fun setupNavController() {
		val appBarConfiguration = AppBarConfiguration(
			setOf(
				R.id.navigation_list
			)
		)
		setupActionBarWithNavController(navController, appBarConfiguration)
		navController.addOnDestinationChangedListener { _, _, _ -> }
	}

	override fun onSupportNavigateUp(): Boolean {
		return navController.navigateUp()
	}

}