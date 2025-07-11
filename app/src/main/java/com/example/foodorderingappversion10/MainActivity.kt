package com.example.foodorderingappversion10

import android.app.ActivityManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foodorderingappversion10.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //***************************************************Set the Bottom Navigation with the fragments*************************************************
        var navController=findNavController(R.id.fragmentContainerView)
        var bottmnav=findViewById<BottomNavigationView>(R.id.bottomnav)
        bottmnav.setupWithNavController(navController)



        //**********************************************************************Notification BotomView**********************************
        binding.NotificationBtn.setOnClickListener {
            val bottomSheetDialog= Notification_Fragment()
            bottomSheetDialog.show(supportFragmentManager,"test")
        }
    }
}