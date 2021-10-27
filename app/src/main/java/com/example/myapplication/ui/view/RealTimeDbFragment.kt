package com.example.myapplication.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentRealTimeDbBinding
import com.example.myapplication.utils.DialogController.showDialogAlert
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RealTimeDbFragment : Fragment() {
    private lateinit var binding: FragmentRealTimeDbBinding
    private val myRef = Firebase.database/*(Firebase.app("tesit"))*/.reference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRealTimeDbBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpClickListeners()
    }


    private fun setUpClickListeners() {
        binding.qwe.setOnClickListener {
            showDialogAlert(requireContext(), "Title", "the meassage for the dialoge")
//            myRef.child("message").setValue("Hello, World!")
        }
    }
}