package com.example.foodorderingappversion10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingappversion10.Adapter.NotificationAdapter
import com.example.foodorderingappversion10.databinding.FragmentNotificationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class Notification_Fragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNotificationBinding.inflate(inflater,container,false)

        var notificationitem= arrayListOf<String>("Your Order Has been Cancelled \n Sucessffully","Order Picked By the Driver", "Congrats Your Order Delivered\n Sucessfully")
        var notificationimg= arrayListOf<Int>(R.drawable.sademoji,R.drawable.car,R.drawable.done_tick)

        binding.NotificationRecy.adapter=NotificationAdapter(notificationitem,notificationimg)
        binding.NotificationRecy.layoutManager=LinearLayoutManager(requireContext())

        binding.Notificationback.setOnClickListener {
            dismissNow()
        }
        return binding.root
    }

}