package com.example.proydami.CategoriasAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.proydami.Models.Categoria
import com.example.proydami.R

class CtgsPagerAdapter( private val ct: ArrayList<Categoria>, private val mContext: Context?) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val modelObject = ct[position]
        val inflater = LayoutInflater.from(mContext)
        val view = inflater.inflate(R.layout.item_ctg, collection,false) as View
        //val layout = inflater.inflate(modelObject., collection, false) as ViewGroup

        var image =  view.findViewById<ImageView>(R.id.image)
        var title = view.findViewById<TextView>(R.id.title)
        var desc = view.findViewById<TextView>(R.id.desc)

        image.setImageResource(ct[position].image)
        title.text = ct[position].title
        desc.text = ct[position].desc


        collection.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view === `object`
    }

    override fun getCount(): Int {
        return  ct.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}