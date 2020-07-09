package com.example.proydami.Models

import java.io.Serializable

class Producto(
    var id: Int? = 0,
    var title: String? = null,
    var desc: String? = null,
    var precio: Double? = 0.0) : Serializable