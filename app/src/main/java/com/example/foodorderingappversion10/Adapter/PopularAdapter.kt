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
import com.example.foodorderingappversion10.popularitemdataclass

class PopularAdapter(private val Items:ArrayList<popularitemdataclass>,val context: Context): RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.popular_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(name=Items[position].name,price=Items[position].price,image=Items[position].img)
        holder.Pos(position,name=Items[position].name,price=Items[position].price,image=Items[position].img)
    }

    override fun getItemCount(): Int {
        return Items.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var popImage=itemView.findViewById<ImageView>(R.id.imagePopular)
        var popName=itemView.findViewById<TextView>(R.id.itemnamePopular)

        var popPrice=itemView.findViewById<TextView>(R.id.pricePopular)
        var popAdd=itemView.findViewById<TextView>(R.id.addtocartPopular)

        fun Pos(position:Int, name:String , price:String,image:Int){
            itemView.setOnClickListener {
                if(position!=RecyclerView.NO_POSITION){
                    val intent=Intent(context,FoodDetails::class.java)
                    intent.putExtra("menuitemname",name)
                    intent.putExtra("menuImage",image)
                    intent.putExtra("menuPrice",price)
                    context.startActivity(intent)
                }
            }

        }


        fun bind(name:String , price:String,image:Int){
            popName.text=name
            popPrice.text=price
            popImage.setImageResource(image)
        }
    }
}