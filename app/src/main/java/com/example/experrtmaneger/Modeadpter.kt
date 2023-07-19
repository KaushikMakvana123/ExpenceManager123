package com.example.experrtmaneger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Modeadpter(var AddincomeActivity: AddincomeActivity, var Modelist: ArrayList<modelclas1>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return Modelist.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v: View = LayoutInflater.from(AddincomeActivity).inflate(R.layout.item_file, null)
        val Category  = v.findViewById<TextView>(R.id.txtCategories)
        Category.text=Modelist[position].mode
        return v
    }

}