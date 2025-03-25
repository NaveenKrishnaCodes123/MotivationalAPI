package com.elite.parking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottom_navigation)

        // Set default fragment when the app starts
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, ProfileFragment()) // Default Fragment
                .commit()
        }

        bottomNavView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    setBottomNavItemColors(R.color.colorSelectedHome)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, ProfileFragment())
                        .commit()
                    true
                }
                R.id.nav_history -> {
                    setBottomNavItemColors(R.color.colorSelectedProfile)

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, HistoryFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
        setBottomNavItemColors(R.color.colorUnselectedItem)
    }

    private fun setBottomNavItemColors(selectedColor: Int) {
        // Apply selected color to the selected item
        bottomNavView.itemIconTintList = ContextCompat.getColorStateList(this, selectedColor)
        bottomNavView.itemTextColor = ContextCompat.getColorStateList(this, selectedColor)

        // Optionally, reset other unselected items to a default color (optional)
        // Set unselected colors for all items if needed
        bottomNavView.menu.findItem(R.id.nav_home).isChecked = false
        bottomNavView.menu.findItem(R.id.nav_history).isChecked = false

        bottomNavView.itemIconTintList = ContextCompat.getColorStateList(this, R.color.colorUnselectedItem)
        bottomNavView.itemTextColor = ContextCompat.getColorStateList(this, R.color.colorUnselectedItem)
    }
}


