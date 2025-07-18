package com.example.foodorderingappversion10

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderingappversion10.databinding.ActivityMainBinding
import com.example.foodorderingappversion10.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

    private val binding: ActivityStartBinding by lazy {
        ActivityStartBinding.inflate(layoutInflater)

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

        binding.nextbtn.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}