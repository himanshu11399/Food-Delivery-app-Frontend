package com.example.foodorderingappversion10.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappversion10.Adapter.historyAdapter
import com.example.foodorderingappversion10.R
import com.example.foodorderingappversion10.databinding.FragmentHistoryBinding
import kotlin.collections.arrayListOf


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding= FragmentHistoryBinding.inflate(inflater,container,false)

        val BuyagainItemNames=arrayListOf<String>("pizza1","pizza2","pizza3","pizza4","pizza5","pizza6","pizza7","pizza8","pizza9")
        val BuyagainItemPrices=ArrayList<String>()
        val BuyagainItemImages=ArrayList<Int>()

        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")
        BuyagainItemPrices.add("$27")

        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)
        BuyagainItemImages.add(R.drawable.popular_1)

        binding.buyagainRecy.adapter=historyAdapter(BuyagainItemNames,BuyagainItemPrices,BuyagainItemImages)
        binding.buyagainRecy.layoutManager=LinearLayoutManager(requireContext())

        return binding.root
    }

}