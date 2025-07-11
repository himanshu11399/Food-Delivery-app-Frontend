package com.example.foodorderingappversion10.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.foodorderingappversion10.Adapter.PopularAdapter
import com.example.foodorderingappversion10.R
import com.example.foodorderingappversion10.databinding.FragmentHomeBinding
import com.example.foodorderingappversion10.menu_bottom_sheet
import com.example.foodorderingappversion10.popularitemdataclass


class HomeFragment : Fragment() {

    //Step:1 Binding Object
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        //step-2:- Binding Object Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater,container,false)



        //***********************************************************************Set the bottom sheet**************************************************************
        binding.ViewAllMenuItems.setOnClickListener {
            val bottomSheetDialog= menu_bottom_sheet()
            bottomSheetDialog.show(parentFragmentManager,"testing")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //**********************************************************************Image Scrolling View :-*******************************************************
        var imagelist= ArrayList<SlideModel>()
        imagelist.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.canvaburger, ScaleTypes.FIT))
        imagelist.add(SlideModel(R.drawable.logomain, ScaleTypes.FIT))

        var Imagelist=binding.imageSlider
        Imagelist.setImageList(imagelist)
        Imagelist.setImageList(imagelist, ScaleTypes.FIT)
        Imagelist.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position:Int){
                val itemMessage="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })


        //*****************************************************************Home Items List****************************************************************************************

        val recy=binding.popularitemrecy
        val itemList=ArrayList<popularitemdataclass>()
        itemList.add(popularitemdataclass("Pizza","$12",R.drawable.popular_1))
        itemList.add(popularitemdataclass("Burger","$10",R.drawable.popular_2))
        itemList.add(popularitemdataclass("Pizza","$12",R.drawable.popular_1))
        itemList.add(popularitemdataclass("Pizza2","$12",R.drawable.popular_2))
        itemList.add(popularitemdataclass("Pizza3","$12",R.drawable.popular_1))
        itemList.add(popularitemdataclass("Pizza4","$12",R.drawable.popular_3))
        itemList.add(popularitemdataclass("Pizza5","$12",R.drawable.popular_2))

        recy.layoutManager=LinearLayoutManager(requireContext())
        recy.adapter=PopularAdapter(itemList,requireContext())
    }


}