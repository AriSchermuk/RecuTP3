package com.example.recutp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavBar()
    }

    private fun setupNavBar() {
        val mainNavHost =
            supportFragmentManager.findFragmentById(R.id.main_navhost) as NavHostFragment
        val navController = mainNavHost.navController
        val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottom_navbar)
        bottomNavbar.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val excludedFragments = listOf(
                R.id.loginFragment,
                R.id.registerFragment
            )
            bottomNavbar.visibility =
                if (excludedFragments.contains(destination.id)) View.GONE else View.VISIBLE
        }
        bottomNavbar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_user_list -> {
                    navController.navigate(R.id.userListFragment)
                    true
                }
                R.id.menu_item_favorite_list -> {
                    navController.navigate(R.id.favoriteListFragment)
                    true
                }
                R.id.menu_item_logout -> {
                    navController.navigate(R.id.loginFragment)
                    true
                }
                else -> false
            }
        }
    }
}
