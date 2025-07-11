package com.example.foodorderingappversion10

import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
     var name: MutableList<String>
    internal var image:Int=0
    internal var price:String?=null

    fun adddetails(name:String,price:String,image:Int){
        this.name=name
        this.price=price
        this.image=image

    }
}