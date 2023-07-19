package com.example.experrtmaneger

import DisplayModalClass
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(
    context: Context,
    name: String,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, 1) {
    var list = ArrayList<modelclass>()
    var list2 = ArrayList<modelclas1>()

    override fun onCreate(db: SQLiteDatabase?) {
        var categorytb =
            "create table CategoryTable(id Integer primary key ,name text)"
        db?.execSQL(categorytb)
        var modetb =
            "create table modetabel(id Integer primary key ,name text)"
        db?.execSQL(modetb)
        var tbl =
            "create table tbl(id Integer primary key ,amount Integer ,category Text,datetime Integer,mode Text,note Text)"
        db?.execSQL(tbl)


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun InsertData(name: String) {

        var c = ContentValues()
        c.put("name", name)
        var write = writableDatabase

        var result = write.insert("CategoryTable", null, c)

        Log.e("TAG", "insertData: " + result)
    }

    fun displayCategory(): ArrayList<modelclass> {
        list.clear()
        val db = readableDatabase
        val sql = "select * from CategoryTable"
        val cursor = db.rawQuery(sql, null)

        cursor.moveToFirst()
        do {
            val categoryName = cursor.getString(1)

            list.add(modelclass(categoryName))
        } while (cursor.moveToNext())

        return list


    }

    fun Insertmoddata(name: String) {
        var c = ContentValues()
        c.put("name", name)
        var write = writableDatabase
        var result = write.insert("modetabel", null, c)
        Log.e("TAG", "Insertmoddata: " + result)

    }

    fun Dispalaymode(): ArrayList<modelclas1> {
        list2.clear()
        val db1 = readableDatabase
        val sql = "select * from modetabel"
        val cursor = db1.rawQuery(sql, null)
        cursor.moveToFirst()
        do {
            val payment = cursor.getString(1)
            list2.add(modelclas1(payment))
        } while (cursor.moveToNext())
        return list2


    }

    fun Displaytbl(): ArrayList<DisplayModalClass> {

        val db1 = readableDatabase
        var DisplayList = ArrayList<DisplayModalClass>()
        val sql = "select * from tbl"
        val cursor = db1.rawQuery(sql, null)
        cursor.moveToFirst()
        do {
            val payment = cursor.getString(1)
            list2.add(modelclas1(payment))
        } while (cursor.moveToNext())
        return DisplayList
    }
}
