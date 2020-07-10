package com.example.proydami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proydami.Models.Producto
import com.example.proydami.ProductosAdapters.PrdDetailActivity
import com.example.proydami.ProductosAdapters.PrdsAdapter
import com.example.proydami.SqlLight.CarritoDBHelper
import com.example.proydami.SqlLight.Columns
import kotlinx.android.synthetic.main.activity_carrito.*

class CarritoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)


        rvList.layoutManager = LinearLayoutManager(this)

        rvList.adapter = PrdsAdapter(getPrdsCarrito(),{
            val intentDeatilCard = Intent(this, PrdDetailActivity::class.java)
            intentDeatilCard.putExtra("PRDs", it)

            startActivity(intentDeatilCard)
        }, "list")
    }

    private fun getPrdsCarrito() : ArrayList<Producto>{

        var crrDB : CarritoDBHelper = CarritoDBHelper(this)
        val bd = crrDB!!.readableDatabase

        val columnas = arrayOf(BaseColumns._ID,Columns.CartBC._CODIGO,
            Columns.CartBC._NOMBRE,Columns.CartBC._DESC, Columns.CartBC._PRECIO, Columns.CartBC._CANTIDAD)

        val cursorInfo = bd.query(Columns.CartBC._TABLA, columnas, null,null,null,null, null )

        val prdsOnCarrito = ArrayList<Producto>()

        with(cursorInfo) {
            while (moveToNext()){
                val idrow = getLong(getColumnIndex(android.provider.BaseColumns._ID))
                val id = getLong(getColumnIndex(Columns.CartBC._CODIGO))
                val nombre = getString(getColumnIndex(Columns.CartBC._NOMBRE))
                val desc = getString(getColumnIndex(Columns.CartBC._DESC))
                val pre = getString(getColumnIndex(Columns.CartBC._PRECIO))
                val cant = getString(getColumnIndex(Columns.CartBC._CANTIDAD))
                val prd = Producto(id, nombre, desc, pre.toDouble(), cant.toInt() )

                prdsOnCarrito.add(prd)
            }
        }

        for (p in prdsOnCarrito){
            println(p.id)
            println(p.cantidad)
            println(p.nombre)
        }
        return prdsOnCarrito

    }
}
