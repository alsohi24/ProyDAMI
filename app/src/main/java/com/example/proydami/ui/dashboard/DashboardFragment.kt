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

        val lstPrds = ArrayList<Producto>()
        lstPrds.add(Producto(0,"Parecetamol","",34.0))
        lstPrds.add(Producto(0,"Suplementos","",12.0))
        lstPrds.add(Producto(0,"Complementos","",23.0))
        lstPrds.add(Producto(0,"A1 Pastillas","",324.0))
        lstPrds.add(Producto(0,"Blue Pills","",23.0))
        lstPrds.add(Producto(0,"Curitas","",23.0))
        lstPrds.add(Producto(0,"Jeringas","",12.0))
        lstPrds.add(Producto(0,"Jaraba","",57.0))
        lstPrds.add(Producto(0,"Miel","",45.0))
        lstPrds.add(Producto(0,"Pomada","",343.0))
        lstPrds.add(Producto(0,"Gasas","",224.0))


        //val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {

            rvPrds.layoutManager = GridLayoutManager(context,2)

            rvPrds.adapter = PrdsAdapter(lstPrds,{
                val intentDeatilCard = Intent(context, PrdDetailActivity::class.java)
                intentDeatilCard.putExtra("PRDs", it)

                startActivity(intentDeatilCard)
            })

        })


        return root
    }
}