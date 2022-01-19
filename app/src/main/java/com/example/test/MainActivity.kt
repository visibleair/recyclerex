package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var titlesList= mutableListOf<String>()
    private var descList= mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()



    var url = ""
    var filter = ""
    private var okHttpClient = OkHttpClient()
    private lateinit var request: Request

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle("Обсуждения")
        setContentView(binding.root)





        postToList()

        binding.rvRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.rvRecyclerView.adapter = RecyclerAdapter(titlesList, descList,imagesList)

        filter = "new"
        url = "http://cinema.areas.su/chats$filter"


        request = Request.Builder()
            .url(url)
            .build()

        okHttpClient.newCall(request).enqueue( object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i("tag", "onFailure")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code == 200) {
                    runOnUiThread {
                        Toast.makeText(this@MainActivity, "200", Toast.LENGTH_SHORT).show()
                        Log.i("tag", "onResponse: ${response.body!!.string()}")
                    }
                } else {
                    runOnUiThread { Toast.makeText(this@MainActivity, "401", Toast.LENGTH_SHORT).show() }
                }
            }

        })


    }
    private fun addToList(title: String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for(i in 1..25){
        addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }



}