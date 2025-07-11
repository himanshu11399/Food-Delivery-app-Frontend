package com.example.foodorderingappversion10

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorderingappversion10.databinding.ActivityPayoutBinding

class payout_activity : AppCompatActivity() {
    private val binding:ActivityPayoutBinding by lazy {
        ActivityPayoutBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backPayout.setOnClickListener {
            val intent5=Intent(this, MainActivity::class.java)
            startActivity(intent5)
        }

        binding.PlaceMyOrder.setOnClickListener {
            var BottomSheetDialogFragment= Order_placed()
            BottomSheetDialogFragment.show(supportFragmentManager,"Test")

        }
    }
}