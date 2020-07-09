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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prd_detail)

        val extras = intent.extras

        if (extras != null){
            val p = extras["PRDs"] as? Producto

            tvPrice.text = p?.precio.toString()
            tvName.text = p?.nombre

        }
    }


    fun agregarAlCarrito(nombre:String, poder: String, codigo: String){
        val bd = cartDB!!.writableDatabase

        val values = ContentValues().apply {
            put(Columns.CartBC._CODIGO, codigo.toInt() )
            put(Columns.CartBC._NOMBRE, nombre)
            put(Columns.CartBC._PRECIO, poder)
            put(Columns.CartBC._DESC, poder)
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

}
