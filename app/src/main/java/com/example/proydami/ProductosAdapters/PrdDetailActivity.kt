package com.example.proydami.ProductosAdapters

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.proydami.Models.Producto
import com.example.proydami.R
import com.example.proydami.SqlLight.CarritoDBHelper
import com.example.proydami.SqlLight.Columns
import kotlinx.android.synthetic.main.activity_prd_detail.*

class PrdDetailActivity : AppCompatActivity() {

    var cartDB : CarritoDBHelper? = null

    var p : Producto? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prd_detail)
        cartDB = CarritoDBHelper(this)

        val extras = intent.extras

        if (extras != null){
             p = extras["PRDs"] as? Producto

            tvPrice.text = p?.precio.toString()
            tvName.text = p?.nombre

        }

        btnCesta.setOnClickListener{
            agregarAlCarrito()
        }
    }

    fun agregarAlCarrito(){
        val bd = cartDB!!.writableDatabase

        val values = ContentValues().apply {
            put(Columns.CartBC._CODIGO, p?.id )
            put(Columns.CartBC._NOMBRE, p?.nombre)
            put(Columns.CartBC._PRECIO, p?.precio)
            put(Columns.CartBC._CANTIDAD, p?.cantidad)
            put(Columns.CartBC._DESC, p?.desc)
        }

        val newRowId = bd?.insert(Columns.CartBC._TABLA, null, values)

        if(newRowId != (-1).toLong()){
            Toast.makeText(applicationContext,"Se insertó", Toast.LENGTH_SHORT).show()

            println("inserto")
        }else{
            Toast.makeText(applicationContext,"Valor ya registrado", Toast.LENGTH_SHORT).show()
            println("no inserto")
        }
    }

    fun actulizarCantidad() {
        val bd = cartDB!!.writableDatabase
        val valores = ContentValues().apply {
            put(Columns.CartBC._CANTIDAD, p?.cantidad)
        }
        val sccss = bd.update(Columns.CartBC._TABLA, valores, "${Columns.CartBC._CODIGO} = ${p?.id}", null)

        if(sccss >  0){
            Toast.makeText(applicationContext,"Se actualizó pokemon",Toast.LENGTH_SHORT).show()

            println("actualizó")
        }else{
            Toast.makeText(applicationContext,"No se actualizó pokemon",Toast.LENGTH_SHORT).show()
            println("no actualizó $sccss")
        }

    }

}
