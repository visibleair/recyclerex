package com.example.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.R
import com.example.test.databinding.FragmentCompilationsBinding
import com.example.test.databinding.FragmentProfileBinding


class Compilations : Fragment() {
    private lateinit var binding: FragmentCompilationsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompilationsBinding.inflate(inflater,container,false)
        return binding.root
    }


}