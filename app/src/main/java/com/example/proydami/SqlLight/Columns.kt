package com.example.proydami.SqlLight

import android.provider.BaseColumns

class Columns {

    object  CartBC : BaseColumns{

        const val _TABLA = "carrito"
        const val _CODIGO = "id"
        const val _NOMBRE = "nombre"
        const val _DESC = "desc"
        const val _PRECIO = "precio"
        const val _CANTIDAD = "cantidad"
    }
}

//var id: Int? = 0,
//var title: String? = null,
//var desc: String? = null,
//var precio: Double? = 0.0