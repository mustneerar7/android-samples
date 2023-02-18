package com.mony.navigationcomponentsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mony.navigationcomponentsample.databinding.ActivityMainBinding
import com.mony.navigationcomponentsample.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /* Access the bottom navigation view object. */
        val navView : BottomNavigationView = binding.bottomNavigationView

        /* Gets the controller of nav_host_fragment. */
        navController = findNavController(R.id.nav_host_fragment)

        /* Links the bottom appbar to navigation graph and menu. */
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home2, R.id.gallery, R.id.chats
            )
        )

        /* Configures action bar with the modified configuration. */
        setupActionBarWithNavController(navController, appBarConfiguration)

        /* Use this instead if you want custom back stack behaviour. */
        // setupActionBarWithNavController(navController)

        /* Links the nav controller to bottom navigation bar. */
        navView.setupWithNavController(navController)
    }

    /* Enables back button on appbar. Not functional in this app. */
    override fun onSupportNavigateUp():Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}