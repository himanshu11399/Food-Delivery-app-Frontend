package com.example.foodorderingappversion10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.foodorderingappversion10.Fragment.CartFragment
import com.example.foodorderingappversion10.Fragment.Cart_Data_Class
import com.example.foodorderingappversion10.databinding.ActivityFoodDetailsBinding
import kotlin.jvm.java

class FoodDetails : AppCompatActivity() {
    private val binding:ActivityFoodDetailsBinding by lazy{
        ActivityFoodDetailsBinding.inflate(layoutInflater)
    }
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Receive the value from the Popular Activity
        val name=intent.getStringExtra("menuitemname")
        val price=intent.getStringExtra("menuPrice")
        val image=intent.getIntExtra("menuImage",0)

        binding.FoodName.text=name
        binding.FoodImage.setImageResource(image)


        //Add item to the cart
        binding.addtoitcart.setOnClickListener {
          viewModel=ViewModelProvider(this)[MyViewModel::class.java]
            viewModel.adddetails(name.toString(),price.toString(),image)
            Toast.makeText(this,"Item added in viewModel",Toast.LENGTH_SHORT).show()
        }

        binding.backtomain.setOnClickListener {
            finish()
        }


    }
}