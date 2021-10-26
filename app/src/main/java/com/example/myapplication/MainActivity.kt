package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Utils.Constants
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.google.firebase.ktx.initialize

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeFirebase()

        binding.crashButton.setOnClickListener {
            val database = Firebase.database(Firebase.app("tesit"))
            val myRef = database.reference
            myRef.child("message").setValue("Hello, World!")
        }

    }

    private fun initializeFirebase() {
        val options = FirebaseOptions.Builder()
            .setProjectId(Constants.FIREBASE_PROJECT_ID)
            .setApplicationId(Constants.FIREBASE_APP_ID)
            .setDatabaseUrl(Constants.FIREBASE_DB_URL)
            .build()
            Firebase.initialize(this, options, "tesit")
    }
}