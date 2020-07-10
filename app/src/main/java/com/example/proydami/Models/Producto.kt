package com.example.proydami.Models

import java.io.Serializable

class Producto(
    var id: Long? = 0,
    var nombre: String? = null,
    var desc: String? = null,
    var precio: Double? = 0.0,
    var cantidad: Int? = 0) : Serializable