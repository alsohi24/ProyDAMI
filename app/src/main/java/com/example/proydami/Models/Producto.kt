package com.example.proydami.Models

import java.io.Serializable

class Producto(
    var id: Int? = 0,
    var nombre: String? = null,
    var desc: String? = null,
    var precio: Double? = 0.0) : Serializable