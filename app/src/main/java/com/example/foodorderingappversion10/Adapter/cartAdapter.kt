package com.example.foodorderingappversion10.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingappversion10.Fragment.Cart_Data_Class
import com.example.foodorderingappversion10.R

class cartAdapter(val items2: MutableList<Cart_Data_Class>): RecyclerView.Adapter<cartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.cart_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=items2[position]
        holder.bind(currentItem,position)
        holder.CartImg.setImageResource(items2[position].image)
        holder.CartName.text=items2[position].name
        holder.CartPrice.text=items2[position].price
        holder.quantitytextview.text=items2[position].quantity
    }

    override fun getItemCount(): Int {
        return items2.size
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        val CartImg = itemView.findViewById<ImageView>(R.id.buyagainImg)
        val CartName = itemView.findViewById<TextView>(R.id.buyagainName)
        val CartPrice = itemView.findViewById<TextView>(R.id.buyagainPrice)
        var quantitytextview = itemView.findViewById<TextView>(R.id.CartItemQuantity)

        var addcartbtn = itemView.findViewById<ImageView>(R.id.addcartbtn)
        var minuscartbtn = itemView.findViewById<ImageView>(R.id.minuscartbtn)
        var deletecartbtn = itemView.findViewById<ImageView>(R.id.cartDeletebtn)

        fun bind(dataclass: Cart_Data_Class, position: Int) {
            addcartbtn.setOnClickListener {
                increaseQuantity(dataclass , position)
            }
            minuscartbtn.setOnClickListener {
                decreaseQuantity(dataclass ,position)
            }
            deletecartbtn.setOnClickListener {
                deleteItem(position)

            }
        }

        fun decreaseQuantity(item: Cart_Data_Class, position: Int) {
            var currentquantity=item.quantity.toString().toIntOrNull()?:1
            if(currentquantity>1){
                currentquantity--
                item.quantity=currentquantity.toString()
                quantitytextview.text=item.quantity
                notifyItemChanged(position)
            }else{
                Toast.makeText(itemView.context,"Alteast 1 more required",Toast.LENGTH_SHORT).show()
            }
        }
        fun increaseQuantity(item: Cart_Data_Class,position: Int) {
            var currentquantity=item.quantity.toString().toIntOrNull()?:0
            if(currentquantity<10){
                currentquantity++
                item.quantity=currentquantity.toString()
                quantitytextview.text=item.quantity
                notifyItemChanged(position)
            }else{
                Toast.makeText(itemView.context,"Maximum Quantity Reached",Toast.LENGTH_SHORT).show()
            }
        }
        fun deleteItem(position: Int) {
            if(position>=1 && items2.size>0){
                Toast.makeText(itemView.context,"${items2[position].name} Deleted", Toast.LENGTH_SHORT).show()
                items2.removeAt(position)
                notifyItemRemoved(position)
            }else{
                Toast.makeText(itemView.context,"Atleast 1 item \nshould be there" , Toast.LENGTH_SHORT).show()
            }
        }



    }
}