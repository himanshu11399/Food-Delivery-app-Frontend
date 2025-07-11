package com.example.foodorderingappversion10

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderingappversion10.databinding.ActivityChooseLoactionBinding

class choose_loaction : AppCompatActivity() {
    private val binding:ActivityChooseLoactionBinding by lazy {
        ActivityChooseLoactionBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
  val locationList=arrayOf("Islamnager","Bariely","Moradabad","Chandausi","Bhajoi","Kanpur","Odisha","Nagpur","Nepal","china")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        binding.listofLocation.setAdapter(adapter)


    }
}