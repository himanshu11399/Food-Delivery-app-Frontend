package com.example.foodorderingappversion10.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappversion10.Adapter.cartAdapter
import com.example.foodorderingappversion10.MyViewModel
import com.example.foodorderingappversion10.R
import com.example.foodorderingappversion10.databinding.FragmentCartBinding
import com.example.foodorderingappversion10.payout_activity
import kotlin.jvm.java

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel:MyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val recy=binding.cartRecy
        val cartitem= mutableListOf<Cart_Data_Class>()
//        cartitem.add(Cart_Data_Class("Pizza","$27",R.drawable.popular_1,"1"))
//        cartitem.add(Cart_Data_Class("Pizza","$27",R.drawable.popular_2,"1"))
//        cartitem.add(Cart_Data_Class("Pizza","$27",R.drawable.popular_3,"1"))

        //Receive data from Add to cart items and add it to the cart
         viewModel= ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
          var itemname=viewModel.name
        var itemprice=viewModel.price
        var itemimage=viewModel.image

        itemname?.let{name->
            itemprice?.let{price->
                itemimage?.let{image->
                    cartitem.add(Cart_Data_Class(name,price,image,"1"))
                }
            }
        }


        recy.layoutManager=LinearLayoutManager(requireContext())
        recy.adapter= cartAdapter(cartitem)

        binding.cartProceed.setOnClickListener {
            val intent=Intent(requireContext(),payout_activity::class.java)
            startActivity(intent)
        }


        return binding.root
    }


}