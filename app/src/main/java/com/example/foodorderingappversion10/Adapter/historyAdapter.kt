package com.example.foodorderingappversion10.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingappversion10.R

class historyAdapter(private val buyagainFoodName: ArrayList<String>, private val buyagainFoodPrice: ArrayList<String>, private val buyagainFoodImage: ArrayList<Int>)
    : RecyclerView.Adapter<historyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.buy_again_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.foodName.text=buyagainFoodName[position]
        holder.foodPrice.text=buyagainFoodPrice[position]
        holder.foodImage.setImageResource(buyagainFoodImage[position])
    }

    override fun getItemCount(): Int {
        return buyagainFoodName.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val foodImage: ImageView = itemView.findViewById(R.id.buyagainImg)
        val foodName: TextView = itemView.findViewById(R.id.buyagainName)
        val foodPrice: TextView = itemView.findViewById(R.id.buyagainPrice)

    }
}