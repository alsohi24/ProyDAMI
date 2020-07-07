package com.example.proydami.CategoriasAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.Models.Categoria
import com.example.proydami.R

class CtgsAdapter (val listCtgs:ArrayList<Categoria>): RecyclerView.Adapter<CtgsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CtgsViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_ctg, parent, false)
        return CtgsViewHolder(vista)
    }

    override fun getItemCount(): Int {
        return listCtgs.size
    }

    override fun onBindViewHolder(holder: CtgsViewHolder, position: Int) {
        val cat = listCtgs[position]

        holder.lblimage.setImageResource(cat.image)
        holder.lbltitle.text = cat.title
        holder.lbldesc.text = cat.desc

    }

}
