package com.example.rescueapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.rescueapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //navController = this.findNavController(R.id.myNavHostFragment)
        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = fragmentContainer.navController
        NavigationUI.setupActionBarWithNavController(this,navController)
        val bottomAppBar: BottomNavigationView = findViewById(R.id.bottomNav)
        bottomAppBar.setupWithNavController(navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}

