package com.example.foodorderingappversion10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappversion10.Adapter.menuItemAdapter
import com.example.foodorderingappversion10.R
import com.example.foodorderingappversion10.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class menu_bottom_sheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         binding= FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        val menuItemName= mutableListOf<String>("pizza","Pizza2","pizza3","pizza4","pizza6")
        val menuItemPrice=mutableListOf<String>("$18","$15","$14","$15","$18")
        val menuItemImage=mutableListOf<Int>(
            R.drawable.popular_1,
            R.drawable.popular_2,
            R.drawable.popular_3,
            R.drawable.popular_1,
            R.drawable.popular_2)

        binding.menubackbtn.setOnClickListener {
            dismissNow()
        }

        binding.menuitemRecy.adapter= menuItemAdapter(menuItemName,menuItemPrice,menuItemImage,requireContext())
        binding.menuitemRecy.layoutManager= LinearLayoutManager(requireContext())

        return binding.root
    }

}