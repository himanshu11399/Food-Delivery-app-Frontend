package com.example.foodorderingappversion10.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappversion10.Adapter.menuItemAdapter
import com.example.foodorderingappversion10.R
import com.example.foodorderingappversion10.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private val originalFoodName =
        mutableListOf("Burger", "Pizza", "Momos", "Garlic bread", "Aloo", "pizza2", "Chawomein")
    private val originalItemPrice =
        mutableListOf<String>("$18", "$15", "$14", "$15", "$18", "$21", "$45", "$46")
    private val originalItemImage = mutableListOf<Int>(
        R.drawable.popular_1,
        R.drawable.popular_2,
        R.drawable.popular_3,
        R.drawable.popular_1,
        R.drawable.popular_2,
        R.drawable.popular_1,
        R.drawable.popular_2,
        R.drawable.popular_3
    )

    private var filteredFoodName = mutableListOf<String>()
    private var filteredItemPrice = mutableListOf<String>()
    private var filteredItemImage = mutableListOf<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)


        //************************************************************Set the Recycler View in searchview***************************************************

        binding.menuitemrecy.adapter =
            menuItemAdapter(filteredFoodName, filteredItemPrice, filteredItemImage, requireContext())
        binding.menuitemrecy.layoutManager = LinearLayoutManager(requireContext())

        //******************************************Set Up the search View*************************************

        binding.SearchViewmenu.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filteredMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filteredMenuItem(newText)
                return true
            }

        })


        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filteredMenuItem(query: String?) {
        filteredFoodName.clear()
        filteredItemPrice.clear()
        filteredItemImage.clear()
        for (i in 0 until originalFoodName.size) {
            val searchText = query?.trim() ?: ""
            if (originalFoodName[i].contains(searchText.toString(),ignoreCase = true)) {
                filteredFoodName.add(originalFoodName[i])
                filteredItemPrice.add(originalItemPrice[i])
                filteredItemImage.add(originalItemImage[i])

            }
        }
        binding.menuitemrecy.adapter?.notifyDataSetChanged()
    }
}