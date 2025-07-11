package com.example.foodorderingappversion10.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingappversion10.R

class NotificationAdapter(private var NotificationItem: ArrayList<String>,private var notificationImg: ArrayList<Int>):
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.notification_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.NotificationDescription.text=NotificationItem[position]
        holder.notificationImg.setImageResource(notificationImg[position])
    }

    override fun getItemCount(): Int {
      return NotificationItem.size
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
       val NotificationDescription=itemView.findViewById<TextView>(R.id.NotificationDescription)
       val notificationImg=itemView.findViewById<ImageView>(R.id.NotificationImg)
    }
}