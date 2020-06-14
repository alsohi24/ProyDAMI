package com.example.proydami

import com.google.gson.annotations.SerializedName

data class Productos (@SerializedName("status") var status:String, @SerializedName("message") var images: List<String>)