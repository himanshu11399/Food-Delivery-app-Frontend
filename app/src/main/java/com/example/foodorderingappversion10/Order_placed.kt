package com.example.foodorderingappversion10

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingappversion10.databinding.FragmentOrderPlacedBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Order_placed : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentOrderPlacedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentOrderPlacedBinding.inflate(layoutInflater)

        binding.orderbackBtn.setOnClickListener {
            val intent6=Intent(requireContext(), MainActivity::class.java)
            startActivity(intent6)
        }
        return binding.root
    }

}