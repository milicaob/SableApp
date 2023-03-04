package com.example.sable

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.bumptech.glide.Glide
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.sable.ui.login.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val SELECT_IMAGE_REQUEST_CODE = 1

class Home : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var btNav: BottomNavigationView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_2) as NavHostFragment
        val navController = navHostFragment.navController

        layoutManager = LinearLayoutManager(this)

        val activity = this
        val recyclerView = activity.findViewById<RecyclerView>(R.id.recycler_view)
        btNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //btNav?.inflateMenu(R.menu.bottom_nav_menu)
        //btNav?.setupWithNavController(navController)


        btNav?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.action_userFragment_to_homeF)
                    true
                }
                R.id.navigation_user -> {
                    navController.navigate(R.id.action_homeF_to_userFragment)
                    true
                }
                else -> false
            }

        }


    }

    override fun onStart() {
        super.onStart()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_2) as NavHostFragment
    }
}








