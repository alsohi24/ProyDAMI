package com.example.proydami.ProductosAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.Models.Producto
import com.example.proydami.R

class PrdsAdapter (private val prdList: List<Producto>,
                   val showDetail: (Producto) -> Unit,
                   val tipo: String) : RecyclerView.Adapter<PrdsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrdsViewHolder {

        var lay = R.layout.card_prod

        if(tipo == "list"){
            lay = R.layout.item_prod
        }else{
            lay = R.layout.card_prod
        }

        val view = LayoutInflater.from(parent.context).inflate(lay, parent, false)
        return PrdsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return prdList.size
    }

    override fun onBindViewHolder(holder: PrdsViewHolder, position: Int) {
        val prd = prdList[position]

        holder.lblimage.setImageResource(R.drawable.img1)
        holder.lblnameprod.text = prd.nombre
        holder.lblprice.text = prd.precio.toString()
        holder.itemView.setOnClickListener{
            showDetail(prd)
        }
    }
}