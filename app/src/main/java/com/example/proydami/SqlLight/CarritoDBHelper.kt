package com.example.proydami.SqlLight

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class CarritoDBHelper (context: Context):
    SQLiteOpenHelper(context,"LocalStorage.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(sql_create_tb_cart)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(sql_eliminar_tb_cart)
        onCreate(db)
    }

    private val sql_create_tb_cart = "Create table ${Columns.CartBC._TABLA} (" +
            "${BaseColumns._ID} integer," +
            "${Columns.CartBC._CODIGO} integer primary key," +
            "${Columns.CartBC._NOMBRE} text," +
            "${Columns.CartBC._DESC} text," +
            "${Columns.CartBC._PRECIO} real)"

    private val sql_eliminar_tb_cart = "DROP TABLE IF EXIST ${Columns.CartBC._TABLA}"
}