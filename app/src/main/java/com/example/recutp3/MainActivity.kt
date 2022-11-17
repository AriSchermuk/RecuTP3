package com.example.recutp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        findViewById<BottomNavigationView>(R.id.bottom_navbar).setupWithNavController(navController)
    }
}
