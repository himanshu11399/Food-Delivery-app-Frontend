package com.example.foodorderingappversion10.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingappversion10.FoodDetails
import com.example.foodorderingappversion10.R


class menuItemAdapter(val menuitemsName: MutableList<String>, val menuitemprice: MutableList<String>,val menuImage: MutableList<Int> , private val requireContext:Context): RecyclerView.Adapter<menuItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name=menuitemsName[position],price=menuitemprice[position],image=menuImage[position])
        holder.Pos(position)

    }

    override fun getItemCount(): Int {
       return  menuitemsName.size
    }


    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
      val tvmenuitemname=itemView.findViewById<TextView>(R.id.menuitemname)
        val tvmenuPrice=itemView.findViewById<TextView>(R.id.menuprice)
        val ivmenuImage=itemView.findViewById<ImageView>(R.id.menuimage)


        //Apply set On click Listener
        fun Pos(position: Int) {
                itemView.setOnClickListener {
                    if (position != RecyclerView.NO_POSITION) {
                        val intent = Intent(requireContext, FoodDetails::class.java)
                        intent.putExtra("menuitemname", menuitemsName[position])
                        intent.putExtra("menuImage", menuImage[position])
                        intent.putExtra("menuPrice", menuitemprice[position])
                        requireContext.startActivity(intent)
                    }
                }

        }

        fun bind(name:String , price:String,image:Int){
            tvmenuitemname.text=name
            tvmenuPrice.text=price
            ivmenuImage.setImageResource(image)

        }



    }
}