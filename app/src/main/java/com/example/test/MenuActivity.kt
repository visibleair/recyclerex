package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.test.databinding.ActivityMenuBinding
import com.example.test.fragments.Collections
import com.example.test.fragments.Compilations
import com.example.test.fragments.Main
import com.example.test.fragments.Profile


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Main()).commit()
        binding.bottomContainer.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.item1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Main()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item2 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Compilations()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Collections()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.item4 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Profile()).commit()
                    return@setOnItemSelectedListener true
                }
            }
            return@setOnItemSelectedListener false
        }


    }
}