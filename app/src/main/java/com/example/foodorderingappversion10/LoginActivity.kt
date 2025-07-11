package com.example.foodorderingappversion10

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderingappversion10.databinding.ActivityLoginBinding
import com.example.foodorderingappversion10.databinding.ActivityStartBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.noaccount.setOnClickListener {
            val intent=Intent(this, SignUp::class.java)
            startActivity(intent)
        }

        binding.loginbtn.setOnClickListener {

            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}