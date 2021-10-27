package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myapplication.utils.Constants
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.FirebaseOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setUpNavController()
        initializeFirebase()

    }

    private fun initializeFirebase() {
        val options = FirebaseOptions.Builder()
            .setProjectId(Constants.FIREBASE_PROJECT_ID)
            .setApplicationId(Constants.FIREBASE_APP_ID)
            .setDatabaseUrl(Constants.FIREBASE_DB_URL)
            .build()
        Firebase.initialize(this, options, "tesit")
    }

    private fun setUpNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        var navController: NavController = navHostFragment.navController
        supportActionBar!!.title = "title"
    }

}