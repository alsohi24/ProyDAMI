package com.example.proydami.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proydami.CarritoActivity
import com.example.proydami.Models.Producto
import com.example.proydami.ProductosAdapters.PrdDetailActivity
import com.example.proydami.ProductosAdapters.PrdsAdapter
import com.example.proydami.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        //val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {

            rvPrds.layoutManager = GridLayoutManager(context,2)

            rvPrds.adapter = PrdsAdapter(getPrds(),{
                val intentDeatilCard = Intent(context, PrdDetailActivity::class.java)
                intentDeatilCard.putExtra("PRDs", it)

                startActivity(intentDeatilCard)
            }, "grid")

            cart.setOnClickListener{
                val intentCarr = Intent(context, CarritoActivity::class.java)
                //intentCarr.putExtra("PRDs", it)

                startActivity(intentCarr)
            }

        })


        return root
    }

    fun getPrds() :  ArrayList<Producto>{
        val lstPrds = ArrayList<Producto>()
        lstPrds.add(Producto(0,"Parecetamol","",34.0, 21))
        lstPrds.add(Producto(2,"Suplementos","",12.0, 88))
        lstPrds.add(Producto(3,"Complementos","",23.0, cantidad = 45))
        lstPrds.add(Producto(4,"A1 Pastillas","",324.0, cantidad = 56))
        lstPrds.add(Producto(5,"Blue Pills","",23.0, cantidad = 76))
        lstPrds.add(Producto(6,"Curitas","",23.0, cantidad = 23))
        lstPrds.add(Producto(7,"Jeringas","",12.0, cantidad = 34))
        lstPrds.add(Producto(8,"Jaraba","",57.0, cantidad = 54))
        lstPrds.add(Producto(9,"Miel","",45.0, cantidad = 12))
        lstPrds.add(Producto(10,"Pomada","",343.0, cantidad = 23))
        lstPrds.add(Producto(11,"Gasas","",224.0, cantidad = 45))

        return lstPrds

    }
}


