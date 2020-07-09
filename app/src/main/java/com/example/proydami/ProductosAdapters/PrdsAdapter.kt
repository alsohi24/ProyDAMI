package com.example.proydami.ProductosAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.Models.Producto
import com.example.proydami.R

class PrdsAdapter (private val prdList: List<Producto>,
                   val showDetail: (Producto) -> Unit ) : RecyclerView.Adapter<PrdsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrdsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_prod, parent, false)
        return PrdsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return prdList.size
    }

    override fun onBindViewHolder(holder: PrdsViewHolder, position: Int) {
        val prd = prdList[position]

        holder.lblimage.setImageResource(R.drawable.img1)
        holder.lblnameprod.text = prd.title
        holder.lblprice.text = prd.precio.toString()
        holder.itemView.setOnClickListener{
            showDetail(prd)
        }
    }
}