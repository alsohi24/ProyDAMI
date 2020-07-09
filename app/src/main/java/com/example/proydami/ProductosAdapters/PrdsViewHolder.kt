package com.example.proydami.ProductosAdapters

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.Models.Producto
import com.example.proydami.R

class PrdsViewHolder(iv: View): RecyclerView.ViewHolder(iv) {

    var lblimage =  itemView.findViewById<ImageView>(R.id.p_image)
    val lblnameprod=  itemView.findViewById<TextView>(R.id.p_name)
    val lblprice=  itemView.findViewById<TextView>(R.id.p_price)

//    fun openCardDetail(p:Producto, context: Context){
//        itemView.setOnClickListener(View.OnClickListener {
//
//        })
//    }
}