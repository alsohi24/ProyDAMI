package com.example.proydami.Adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.R
import kotlinx.android.synthetic.main.item_ctg.view.*

class CtgsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var lblimage =  itemView.findViewById<ImageView>(R.id.image)
    val lbltitle=  itemView.findViewById<TextView>(R.id.title)
    val lbldesc=  itemView.findViewById<TextView>(R.id.desc)

}