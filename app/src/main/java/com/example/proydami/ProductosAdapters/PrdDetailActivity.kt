package com.example.proydami.ProductosAdapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proydami.Models.Producto
import com.example.proydami.R
import kotlinx.android.synthetic.main.activity_prd_detail.*

class PrdDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prd_detail)

        var extras = intent.extras

        if (extras != null){
            val p = extras["PRDs"] as? Producto

            tvPrice.text = p?.precio.toString()
            tvName.text = p?.title

        }
    }
}
