package com.example.test.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.MainActivity
import com.example.test.R
import com.example.test.databinding.ActivityMainBinding
import com.example.test.databinding.FragmentMainBinding



class Main : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.button.setOnClickListener(){
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        return binding.root


    }


}