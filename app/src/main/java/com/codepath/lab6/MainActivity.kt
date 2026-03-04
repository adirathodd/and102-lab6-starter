package com.codepath.lab6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codepath.lab6.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.serialization.json.Json

// Helper function for JSON parsing
fun createJson() = Json {
    isLenient = true
    ignoreUnknownKeys = true
    useAlternativeNames = false
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show Parks fragment by default
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ParksFragment.newInstance())
                .commit()
        }

        // Set up Bottom Navigation
        val bottomNavigation: BottomNavigationView = binding.bottomNavigation
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_parks -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ParksFragment.newInstance())
                        .commit()
                    true
                }
                R.id.action_campgrounds -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CampgroundFragment.newInstance())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
