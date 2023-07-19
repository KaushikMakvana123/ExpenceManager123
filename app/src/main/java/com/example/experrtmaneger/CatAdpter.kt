package com.example.e2345.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.experrtmaneger.AddincomeActivity
import com.example.experrtmaneger.R
import com.example.experrtmaneger.modelclass


class CatAdapter(var AddincomeActivity: AddincomeActivity, var Categorylist: ArrayList<modelclass>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return Categorylist.size
    }

    override fun getItem(p0: Int): Any? {

        return null


    }

    override fun getItemId(p0: Int): Long {
        return 0

    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val v: View = LayoutInflater.from(AddincomeActivity).inflate(R.layout.item_file, null)
        val Category  = v.findViewById<TextView>(R.id.txtCategories)
        Category.text=Categorylist[p0].category
        return v


    }


    fun refresh(list: ArrayList<modelclass>) {

    }


}